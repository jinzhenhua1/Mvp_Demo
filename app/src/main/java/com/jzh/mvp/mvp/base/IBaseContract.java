package com.jzh.mvp.mvp.base;

public class IBaseContract {
    public interface IBasePresenter {

        public void onStop();

        public void onDestory();

        /**
         * 判断 presenter 是否与 view 建立联系，防止出现内存泄露状况
         *
         * @return {@code true}: 联系已建立<br>{@code false}: 联系已断开
         */
        public boolean isViewAttach();
    }

    public interface IBaseView {

        public void  showError(String msg);

        public void  showLoadingWithMessage(String loadingText);

        public void  showLoading();

        public void  showContent(String message, int duration);

        public void  dismissLoading();

        /**
         * 显示提示框
         * @param msg
         */
        public void  showInquiryDialog(String msg);

        /**
         * 显示确定提示框
         * @param title         提示标题
         * @param message       提示内容
         * @param buttonConfirm 确定按钮文字
         * @param buttonCancel  取消按钮文字
         */
        public void showConfirmDialog(String title, String message, String buttonConfirm, String buttonCancel);
    }

    public interface IBaseModel{
        public static final int STATUS_FAIL = -1;// 验证失败
        public static final int STATUS_SUCCESS = 0;// 成功
        public static final int STATUS_NORMAL = 1;// 正常状态
        public static final int STATUS_VERIFY_ING = 2;// 正常状态

        public void onStop();

        public void onDestory();
    }
}

