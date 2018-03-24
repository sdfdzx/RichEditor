package com.study.xuan.editor.operate;

import com.study.xuan.editor.operate.param.IParamManger;
import com.study.xuan.editor.operate.param.ParamManager;
import com.study.xuan.editor.operate.span.factory.AbstractSpanFactory;
import com.study.xuan.editor.operate.span.factory.IAbstractSpanFactory;
import com.study.xuan.editor.widget.panel.IPanel;
import com.study.xuan.editor.widget.panel.PanelBuilder;

/**
 * Author : xuan.
 * Date : 18-3-24.
 * Description : RichEditor的构造者
 */
public class RichBuilder {
    private volatile static RichBuilder builder;
    private IPanel panelBuilder;
    private IParamManger manger;
    private IAbstractSpanFactory factory;

    public static synchronized RichBuilder getInstance() {
        if (builder == null) {
            synchronized (RichBuilder.class) {
                if (builder == null) {
                    builder = new RichBuilder();
                }
            }
        }
        return builder;
    }

    public RichBuilder() {
        panelBuilder = new PanelBuilder();
        manger = new ParamManager();
        factory = new AbstractSpanFactory();
    }

    public IPanel getPanelBuilder() {
        return panelBuilder;
    }

    public IParamManger getManger() {
        return manger;
    }

    public IAbstractSpanFactory getFactory() {
        return factory;
    }
}
