package com.androutils.dialogfragmentexperiments

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.androutils.dialogfragmentexperiments.databinding.DialogType1ErrorsBinding
import com.androutils.dialogfragmentexperiments.databinding.DialogfragmentType1ErrorsBinding

class Type1ErrorsDialogFragment: DialogFragment() {

    private lateinit var errorMessage: String
    var dialogInteractionListener: OnDialogInteractionListener? = null

    companion object{
        const val ARG_ERROR_MESSAGE = "arg_error_message"

        fun newInstance(errorMessage: String): Type1ErrorsDialogFragment {
            val myFragment = Type1ErrorsDialogFragment()
            val args = Bundle()
            args.putString(ARG_ERROR_MESSAGE, errorMessage)
            myFragment.arguments = args
            return myFragment
        }
    }

    private lateinit var binding: DialogfragmentType1ErrorsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set custom style
        setStyle(STYLE_NO_TITLE, R.style.OPDBannerDialog)
        errorMessage = arguments?.getString(ARG_ERROR_MESSAGE) ?: "There was a problem"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogfragmentType1ErrorsBinding.inflate(inflater, container, false)

        dialog?.apply {
            window?.requestFeature(Window.FEATURE_NO_TITLE)
            setCanceledOnTouchOutside(false)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<TextView>(R.id.error_message).text = errorMessage

        // Interaction listeners for 'Retry' and 'Dismiss'
        view.findViewById<ViewGroup>(R.id.action_retry).setOnClickListener{
            dialogInteractionListener?.onClickRetry()
        }
        view.findViewById<ViewGroup>(R.id.action_dismiss).setOnClickListener{
            dismiss()
        }
    }

    interface OnDialogInteractionListener{
        fun onClickRetry()
    }
}