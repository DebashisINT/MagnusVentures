package com.breezefieldmagnus.features.mylearning

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.breezefieldmagnus.CorrectQuesAnsFrag
import com.breezefieldmagnus.R
import com.breezefieldmagnus.app.NetworkConstant
import com.breezefieldmagnus.app.Pref
import com.breezefieldmagnus.app.types.FragType
import com.breezefieldmagnus.app.utils.AppUtils
import com.breezefieldmagnus.base.presentation.BaseActivity
import com.breezefieldmagnus.base.presentation.BaseFragment
import com.breezefieldmagnus.features.dashboard.presentation.DashboardActivity
import com.breezefieldmagnus.features.mylearning.apiCall.LMSRepoProvider
import com.pnikosis.materialishprogress.ProgressWheel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class InCorrectQuesAnsFrag : BaseFragment() , View.OnClickListener, RetryInCorrectQuestionAnswerAdapter.OnRetryClickListener{

    private lateinit var recyclerView: RecyclerView
    private lateinit var incrrct_anim: LottieAnimationView
    private lateinit var adapter: RetryInCorrectQuestionAnswerAdapter
    private lateinit var mContext: Context
    private lateinit var no_incrcct_answr: TextView
    private lateinit var content_name: TextView
    lateinit var progress_wheel: ProgressWheel


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    companion object {
        var topicId: String = ""
        var storeContentId: String = ""
        var store_content_url: String = ""

        fun getInstance(topicId: String, storeContentId: String,store_content_url:String): InCorrectQuesAnsFrag {
            val fragment = InCorrectQuesAnsFrag()
            this.topicId = topicId
            this.storeContentId = storeContentId
            this.store_content_url = store_content_url
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_in_correct_ques_ans, container, false)
        initView(view)
        println("Topic ID: ${topicId}")
        println("Store Content ID: ${storeContentId}")
        println("Store Content URL: ${store_content_url}")
        return view
    }

    private fun initView(view: View) {
        recyclerView = view.findViewById(R.id.rv_incorrect_answer_tab)
        content_name = view.findViewById(R.id.content_name)
        no_incrcct_answr = view.findViewById(R.id.no_incrcct_answr)
        incrrct_anim = view.findViewById(R.id.incrrct_anim)
        progress_wheel = view.findViewById(R.id.incrct_progress_wheel)
        recyclerView.layoutManager = LinearLayoutManager(mContext)
        getTopicContentWiseAnswerListsAPICalling()

    }

    private fun getTopicContentWiseAnswerListsAPICalling() {

        try {
            progress_wheel.visibility = View.VISIBLE
            Timber.d("deleteImei call" + AppUtils.getCurrentDateTime())
            val repository = LMSRepoProvider.getTopicList()
            BaseActivity.compositeDisposable.add(
                repository.getTopicContentWiseAnswerLists(
                    Pref.user_id!!,
                    topicId,
                    storeContentId
                )
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe({ result ->
                        val response = result as TopicContentWiseAnswerListsFetchResponse
                        if (response.status == NetworkConstant.SUCCESS) {
                            progress_wheel.visibility = View.GONE

                            try {
                                content_name.setText("Content name : "+response.content_name)
                                if (response.question_answer_fetch_list != null && response.question_answer_fetch_list.isNotEmpty()) {
                                    // Filter list to get only the items with isCorrectAnswer set to false (incorrect answers)
                                    val incorrectAnswers = response.question_answer_fetch_list.filter { !it.isCorrectAnswer }
                                    println("Incorrect Answers: $incorrectAnswers")

                                    // Filter list to get only the items with isCorrectAnswer set to true (correct answers)
                                    val correctAnswers = response.question_answer_fetch_list.filter { it.isCorrectAnswer }
                                    println("Correct Answers: $correctAnswers")



                                    if (incorrectAnswers.size>0) {
                                        recyclerView.visibility = View.VISIBLE
                                        incrrct_anim.visibility = View.VISIBLE
                                        no_incrcct_answr.visibility = View.GONE
                                        adapter = RetryInCorrectQuestionAnswerAdapter(incorrectAnswers ,mContext , this)
                                        recyclerView.adapter = adapter
                                    }else{
                                        recyclerView.visibility = View.GONE
                                        incrrct_anim.visibility = View.VISIBLE
                                        no_incrcct_answr.visibility = View.VISIBLE
                                    }

                                } else {
                                    progress_wheel.visibility = View.GONE
                                    (mContext as DashboardActivity).showSnackMessage(getString(R.string.no_data_found))
                                }
                            } catch (ex: Exception) {
                                ex.printStackTrace()
                            }
                        } else {
                            progress_wheel.visibility = View.GONE
                            (mContext as DashboardActivity).showSnackMessage(getString(R.string.something_went_wrong))

                        }
                    }, { error ->
                        println("errortopicwiselist"+error.message)
                        progress_wheel.visibility = View.GONE
                        (mContext as DashboardActivity).showSnackMessage(getString(R.string.something_went_wrong))
                    })
            )
        } catch (ex: Exception) {
            ex.printStackTrace()
            progress_wheel.visibility = View.GONE
            (mContext as DashboardActivity).showSnackMessage(getString(R.string.something_went_wrong))
        }
    }


    override fun onClick(v: View?) {


    }

    override fun onRetryClicked(question: Question_answer_fetch_list) {

        RetryPlayFrag.play_url = store_content_url
        RetryPlayFrag.question_id = question.question_id
        RetryPlayFrag.topic_id = question.topic_id
        RetryPlayFrag.content_id = question.content_id
        (mContext as DashboardActivity).loadFragment(FragType.RetryPlayFrag, false, "")

    }
}