package com.example.tanisxu.lithotest.components;

import android.support.v7.widget.OrientationHelper;
import android.util.Log;
import android.view.View;

import com.example.tanisxu.lithotest.SnappedRecycler;
import com.facebook.litho.ClickEvent;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentInfo;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.EventHandler;
import com.facebook.litho.StateValue;
import com.facebook.litho.annotations.FromEvent;
import com.facebook.litho.annotations.FromPrepare;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateInitialState;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.annotations.State;
import com.facebook.litho.widget.LinearLayoutInfo;
import com.facebook.litho.widget.Recycler;
import com.facebook.litho.widget.RecyclerBinder;
import com.facebook.litho.widget.Text;

/**
 * Created by Zizhe Xu <zzhxu@mobvoi.com> on 5/2/17.
 */

//@LayoutSpec(events = { ClickEvent.class })
@LayoutSpec
public class TrainExpandCardFlowSpec {

    final static String TAG = "TrainExpandCardFlow";

    private static int height = 400;

    @OnCreateInitialState
    static void createInitialState(
            ComponentContext c,
            StateValue<Boolean> isExpanded) {
        isExpanded.set(false);
    }

    @OnCreateLayout
    static ComponentLayout onCreateLayout(
            ComponentContext c,
            @State boolean isExpanded) {
//            @Prop EventHandler stateChangeHandler) {

        final RecyclerBinder recyclerBinder = new RecyclerBinder(
                c, new LinearLayoutInfo(c.getBaseContext(), OrientationHelper.VERTICAL, false));

        addContent(recyclerBinder, c);


        ComponentLayout component = Recycler.create(c)
                .binder(recyclerBinder)
                .withLayout()
                .clickHandler(TrainExpandCardFlow.onClick1(c))
                .build();

        return component;

//
//        return Text.create(c)
//                .text("dadadas")
//                .withLayout()
//                .heightPx(400)
//                .clickHandler(TrainExpandCardFlow.onClick1(c))
//                .build();



//        final ComponentLayout expandedCard = TrainExpandedCard.create(c).height(height).buildWithLayout();
//        Log.d(TAG, "expand card " + isExpanded);
//        if (isExpanded) {
//            return expandedCard;
//        } else {
//            return component;
//        }
    }

    @OnEvent(ClickEvent.class)
    static void onClick1(
            ComponentContext c,
            @FromEvent View view,
            @State boolean isExpanded) {
        Log.d(TAG, "expand  " + isExpanded + " " + view);
    }

    private static void addContent(RecyclerBinder recyclerBinder, ComponentContext c) {

        for (int i = 0; i < 3; i++) {
            recyclerBinder.insertItemAt(
                    i,
                    ComponentInfo.create()
//                            .component(StationTime.create(c)
//                                    .time("06:22")
//                                    .station("北京南站")
//                                    .clickEventHandler(TrainExpandCardFlow.onClick1(c))
//                                    .build()
//                            )
                            .component(TrainCard.create(c)
//                                            .clickEventHandler(
//                                                    TrainExpandCardFlow.onClick1(c))
                                            .build())
                            .build());
        }
    }
}
