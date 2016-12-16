package io.github.changjiashuai.template.view.image;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jph.takephoto.app.TakePhoto;
import com.jph.takephoto.app.TakePhotoActivity;
import com.jph.takephoto.compress.CompressConfig;
import com.jph.takephoto.model.CropOptions;
import com.jph.takephoto.model.LubanOptions;
import com.jph.takephoto.model.TImage;
import com.jph.takephoto.model.TResult;
import com.jph.takephoto.model.TakePhotoOptions;

import java.io.File;
import java.util.ArrayList;

import io.github.changjiashuai.template.R;
import me.shaohui.advancedluban.Luban;

/**
 * - 支持通过相机拍照获取图片
 * - 支持从相册选择图片
 * - 支持从文件选择图片
 * - 支持多图选择
 * - 支持批量图片裁切
 * - 支持批量图片压缩
 * - 支持对图片进行压缩
 * - 支持对图片进行裁剪
 * - 支持对裁剪及压缩参数自定义
 * - 提供自带裁剪工具(可选)
 * - 支持智能选取及裁剪异常处理
 * - 支持因拍照Activity被回收后的自动恢复
 *
 * @CJS
 */
public class ImageProviderActivity extends TakePhotoActivity {

    private ImageView mImageView;

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, ImageProviderActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_provider);
        mImageView = (ImageView) findViewById(R.id.iv_image);
        configTakePhotoOption(getTakePhoto());
        configCompress(getTakePhoto());

        File file = new File(Environment.getExternalStorageDirectory(), "/temp/" + System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        Uri imageUri = Uri.fromFile(file);

//        camera();
        pick(imageUri);
    }

    @Override
    public void takeCancel() {
        super.takeCancel();
    }

    @Override
    public void takeFail(TResult result, String msg) {
        super.takeFail(result, msg);
    }

    @Override
    public void takeSuccess(TResult result) {
        super.takeSuccess(result);
        showImg(result.getImages());
    }

    private void showImg(ArrayList<TImage> images) {
        TImage tImage = images.get(0);
        Glide.with(this).load(new File(tImage.getCompressPath())).into(mImageView);
    }

    private void camera(Uri imageUri) {
        getTakePhoto().onPickFromCapture(imageUri);
//        getTakePhoto().onPickFromCaptureWithCrop(imageUri, getCropOptions());
    }

    private void pick(Uri imageUri) {
//        getTakePhoto().onPickFromGallery();//相册
//        getTakePhoto().onPickFromDocuments();//文件
        getTakePhoto().onPickFromGalleryWithCrop(imageUri, getCropOptions());
    }

    private void configTakePhotoOption(TakePhoto takePhoto) {
        TakePhotoOptions.Builder builder = new TakePhotoOptions.Builder();
        builder.setWithOwnGallery(true);//自带相册
        builder.setCorrectImage(true);//是对拍的照片进行旋转角度纠正
        takePhoto.setTakePhotoOptions(builder.create());
    }

    /**
     * 压缩
     */
    private void configCompress(TakePhoto takePhoto) {
        int maxSize = 102400;
        int width = 800;
        int height = 800;
        LubanOptions option = new LubanOptions.Builder()
                .setGear(Luban.CUSTOM_GEAR)
                .setMaxHeight(height)
                .setMaxWidth(width)
                .setMaxSize(maxSize)
                .create();
        CompressConfig config = CompressConfig.ofLuban(option);
        config.enableReserveRaw(false);
        takePhoto.onEnableCompress(config, false);
    }

    /**
     * 裁剪
     */
    private CropOptions getCropOptions() {
        int height = 800;
        int width = 800;
        boolean withWonCrop = false;//是否使用自带裁剪界面--可定制
        CropOptions.Builder builder = new CropOptions.Builder();
        builder.setAspectX(width).setAspectY(height);
        builder.setWithOwnCrop(withWonCrop);
        return builder.create();
    }
}
