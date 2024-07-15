package com.example.route.route_task.base

import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

fun Fragment.showDialog(
    title: String? = null,
    message: String? = null,
    posActionName: String? = null,
    posActionCallBack: (() -> Unit)? = null,
    negActionName: String? = null,
    negActionCallBack: (() -> Unit)? = null,
    isCancelable: Boolean = true,
): AlertDialog {
    val alertDialogBuilder = AlertDialog.Builder(requireContext())
    alertDialogBuilder.setMessage(message)

    alertDialogBuilder.setPositiveButton(
        posActionName,
    ) { dialog, _ ->
        dialog?.dismiss()
        posActionCallBack?.invoke()
    }
    alertDialogBuilder.setNegativeButton(
        negActionName,
    ) { dialog, _ ->
        dialog?.dismiss()
        negActionCallBack?.invoke()
    }

    alertDialogBuilder.setCancelable(isCancelable)
    return alertDialogBuilder.show()
}

fun Fragment.showDialog(viewMessage: ViewMessage): AlertDialog {
    return showDialog(
        title = viewMessage.title,
        message = viewMessage.message,
        posActionName = viewMessage.posActionName,
        posActionCallBack = viewMessage.posAction,
        negActionName = viewMessage.negActionName,
        negActionCallBack = viewMessage.negAction,
        isCancelable = viewMessage.isDismissible,
    )
}
