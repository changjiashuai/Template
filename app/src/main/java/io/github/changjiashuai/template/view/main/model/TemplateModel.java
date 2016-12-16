package io.github.changjiashuai.template.view.main.model;

import android.view.View;
import android.widget.TextView;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyModelWithHolder;

import butterknife.BindView;
import io.github.changjiashuai.template.R;
import io.github.changjiashuai.template.base.BaseEpoxyHolder;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 2016/12/14 17:33.
 */

public class TemplateModel extends EpoxyModelWithHolder<TemplateModel.TemplateHolder> {

    @EpoxyAttribute
    String content;
    @EpoxyAttribute(hash = false)
    View.OnClickListener clickListener;

    @Override
    public void bind(TemplateHolder holder) {
        holder.mTvContent.setText(content);
        holder.mTvContent.setOnClickListener(clickListener);
    }

    @Override
    protected TemplateHolder createNewHolder() {
        return new TemplateHolder();
    }

    @Override
    protected int getDefaultLayout() {
        return R.layout.fragment_template_list_item;
    }

    static class TemplateHolder extends BaseEpoxyHolder {
        @BindView(R.id.tv_content)
        TextView mTvContent;
    }
}
