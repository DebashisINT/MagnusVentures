package com.breezefieldmagnus.features.mylearning

import android.app.Activity
import android.content.Context
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.breezefieldmagnus.R
import com.breezefieldmagnus.base.presentation.BaseFragment
import com.pnikosis.materialishprogress.ProgressWheel

class RetryIncorrectQuizFrag : BaseFragment() , View.OnClickListener {
    private lateinit var mContext: Context
    lateinit var progress_wheel: ProgressWheel

    private lateinit var tv_correct_tab: TextView
    private lateinit var tv_incorrect_tab: TextView
    private lateinit var topic_name: TextView
    private lateinit var iv_crct: ImageView
    private lateinit var iv_incrct: ImageView
    private lateinit var ll_correct_tab: LinearLayout
    private lateinit var ll_incorrect_tab: LinearLayout
    private lateinit var retryTabPagerAdapter: RetryTabPagerAdapter
    private lateinit var tab_viewpager: ViewPager

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext=context
    }

    companion object {
        var topic_id: String = ""
        var store_content_id: String = ""
        var store_topic_name: String = ""
        var previousFrag: String = ""
        var store_content_url: String = ""
        fun getInstance(objects: Any): RetryIncorrectQuizFrag {
            val retryIncorrectQuizFrag = RetryIncorrectQuizFrag()

            if (!TextUtils.isEmpty(objects.toString())) {
                val parts = objects.toString().split("~")
                topic_id = parts[0]
                store_content_id = parts[1]
                store_topic_name = parts[2]
                store_content_url = parts[3]
            } else {
                topic_id = ""
                store_content_id = ""
                store_topic_name = ""
                store_content_url = ""
            }
            println("tag_topic_id" + topic_id)

            return retryIncorrectQuizFrag
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_retry_incorrect_quiz, container, false)
        (context as Activity).requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        initView(view)
        initAdapter()
        return view
    }

    private fun initView(view: View) {

        ll_correct_tab = view.findViewById(R.id.ll_correct_tab)
        topic_name = view.findViewById(R.id.topic_name)
        ll_incorrect_tab = view.findViewById(R.id.ll_incorrect_tab)
        tv_correct_tab = view.findViewById(R.id.tv_correct_tab)
        tv_incorrect_tab = view.findViewById(R.id.tv_incorrect_tab)
        iv_crct = view.findViewById(R.id.iv_crct)
        iv_incrct = view.findViewById(R.id.iv_incrct)
        tab_viewpager = view.findViewById(R.id.tab_viewpager)
        retryTabPagerAdapter = RetryTabPagerAdapter(fragmentManager , topic_id , store_content_id ,store_content_url)
        tv_correct_tab.setOnClickListener(this)
        tv_incorrect_tab.setOnClickListener(this)
        //tab_viewpager.currentItem = 0
        tab_viewpager.currentItem = 0
        isIncorrectWise(true)
        ll_correct_tab.setBackground(ContextCompat.getDrawable(mContext, R.drawable.new_retry_correctbtn_bck_inactv))
        ll_incorrect_tab.setBackground(ContextCompat.getDrawable(mContext, R.drawable.new_retry_incorrectbtn_bck ))
        iv_incrct.setBackgroundResource(R.drawable.cross_wt);
        iv_crct.setBackgroundResource(R.drawable.correct_ans_green_check);

        tv_correct_tab.setTextColor(Color.parseColor("#000000"))
        tv_incorrect_tab.setTextColor(Color.parseColor("#FFFFFF"))
        topic_name.setText("Topic name : "+store_topic_name)
        tab_viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                if (position == 0) {
                    isIncorrectWise(true)
                } else {
                    isIncorrectWise(false)
                }
            }

        })
    }

    private fun initAdapter() {
        tab_viewpager.adapter = retryTabPagerAdapter
    }

    open fun refreshAdapter() {
        tab_viewpager.adapter?.notifyDataSetChanged()
    }


    override fun onClick(p0: View?) {
        when (p0!!.id) {

            R.id.tv_incorrect_tab -> {
                isIncorrectWise(true)
                tab_viewpager.currentItem = 0
            }
            R.id.tv_correct_tab -> {
                isIncorrectWise(false)
                tab_viewpager.currentItem = 1
            }
        }
    }

    fun isIncorrectWise(isIncorrectWise: Boolean) {

        if (isIncorrectWise) {
            tv_incorrect_tab.isSelected = true
            tv_correct_tab.isSelected = false

            ll_incorrect_tab.setBackground(ContextCompat.getDrawable(mContext, R.drawable.new_retry_incorrectbtn_bck ))
            ll_correct_tab.setBackground(ContextCompat.getDrawable(mContext, R.drawable.new_retry_correctbtn_bck_inactv))

            iv_incrct.setBackgroundResource(R.drawable.cross_wt);
            iv_crct.setBackgroundResource(R.drawable.correct_ans_green_check);

            tv_incorrect_tab.setTextColor(Color.parseColor("#FFFFFF"))
            tv_correct_tab.setTextColor(Color.parseColor("#000000"))


        } else {
            tv_incorrect_tab.isSelected = false
            tv_correct_tab.isSelected = true

            ll_correct_tab.setBackground(ContextCompat.getDrawable(mContext, R.drawable.new_retry_correctbtn_bck))
            ll_incorrect_tab.setBackground(ContextCompat.getDrawable(mContext, R.drawable.new_retry_incorrectbtn_bck_inactv))

            iv_crct.setBackgroundResource(R.drawable.checked_wt)
            iv_incrct.setBackgroundResource(R.drawable.cross_red);

            tv_correct_tab.setTextColor(Color.parseColor("#FFFFFF"))
            tv_incorrect_tab.setTextColor(Color.parseColor("#000000"))
        }
    }


}