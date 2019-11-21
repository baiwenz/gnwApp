package com.example.mylibrary.presenter;

import com.example.commonlibrary.bean.Repo;
import com.example.commonlibrary.interfaces.OnCallBackListener;
import com.example.commonlibrary.presenter.BasePresenter;
import com.example.mylibrary.model.HomeModel;
import com.example.mylibrary.model.Impl.HomeModelImpl;
import com.example.mylibrary.view.IHomeView;

/**
 * Created by yc on 2018/7/25.
 */
//1.即成basePresenter 获取传递过来的view对象
public class HomePresenter<T extends IHomeView> extends BasePresenter<T> {

    //2。model层的引用 （model 可以直接new创建）
    HomeModel mHomeModel = new HomeModelImpl();

    //3.构造方法 (因为 view 相当于activity 不能直接new创建 ，所以通过构造方法将view视图层传递过来 ，此view继承自 IHomeView)
    public HomePresenter() {
    }

    //4执行获取数据的方法
    public void getHomeData() {
        if (mTWeakReference.get() != null) {
            mTWeakReference.get().showLoading();
            if (mHomeModel != null) {
                mHomeModel.loadDate(new OnCallBackListener<Repo>() {

                    @Override
                    public void onSuccess(Repo apiResult) {
                        mTWeakReference.get().showhome(apiResult);
                    }

                    @Override
                    public void onFailed(String e) {
                        mTWeakReference.get().onError(e);
                    }
                });
            }
        }
    }
}
