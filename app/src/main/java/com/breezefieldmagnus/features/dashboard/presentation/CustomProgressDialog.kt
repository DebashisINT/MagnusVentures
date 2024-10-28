package com.breezefieldmagnus.features.dashboard.presentation

import android.app.Activity
import android.content.Context
import android.os.Bundle
import com.google.android.material.textfield.TextInputLayout
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import com.breezefieldmagnus.R
import com.breezefieldmagnus.app.AppDatabase
import com.breezefieldmagnus.app.Pref
import com.breezefieldmagnus.app.utils.AppUtils
import com.breezefieldmagnus.app.utils.Toaster
import com.breezefieldmagnus.widgets.AppCustomEditText
import com.breezefieldmagnus.widgets.AppCustomTextView

/**
 * Created by Saikat on 26-11-2018.
 */
class CustomProgressDialog : DialogFragment() {

    private lateinit var mContext: Context

    companion object {

        fun getInstance(): CustomProgressDialog {
            return CustomProgressDialog()
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        //dialog.window?.setBackgroundDrawableResource(R.drawable.rounded_corner_white_bg)
        val v = inflater.inflate(R.layout.custom_progress_dialog, container, false)

        isCancelable = false
        return v
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun show(manager: FragmentManager, tag: String?) {
        //super.show(manager, tag)
        val ft = manager?.beginTransaction()
        ft?.add(this, tag)
        try {
            ft?.commit()
        } catch (e: IllegalStateException) {
            e.printStackTrace()
            ft?.commitAllowingStateLoss()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}