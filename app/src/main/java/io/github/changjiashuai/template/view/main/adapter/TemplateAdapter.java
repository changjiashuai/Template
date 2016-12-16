package io.github.changjiashuai.template.view.main.adapter;

import com.airbnb.epoxy.EpoxyAdapter;

import java.util.List;

import io.github.changjiashuai.template.view.main.model.TemplateModel;
import io.github.changjiashuai.template.view.main.model.TemplateModel_;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 2016/12/14 17:32.
 */

public class TemplateAdapter extends EpoxyAdapter {

    //    private List<TemplateModel> mTemplateModels;
    public TemplateAdapter(List<TemplateModel> templateModels) {
        enableDiffing();
        addModels(templateModels);
    }

    public void addTemplates(List<TemplateModel> templateModels){
        addModels(templateModels);
    }

//    public void addPhotos(Collection<Photo> photos) {
//        hideModel(loaderModel);
//        for (Photo photo : photos) {
//            insertModelBefore(new PhotoModel(photo), loaderModel);
//        }
//    }

    public void setData(TemplateModel_ templateModel){
        templateModel.content("");
        notifyModelsChanged();
    }

}
