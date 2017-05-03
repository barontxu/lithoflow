package com.example.tanisxu.lithotest.components;

import com.facebook.litho.ClickEvent;
import com.facebook.litho.Column;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.annotations.PropDefault;

import static com.facebook.yoga.YogaEdge.HORIZONTAL;
import static com.facebook.yoga.YogaEdge.VERTICAL;
import static com.facebook.yoga.YogaJustify.SPACE_BETWEEN;

/**
 * Created by Zizhe Xu <zzhxu@mobvoi.com> on 4/27/17.
 */

@LayoutSpec(events = { ClickEvent.class })
public class TrainCardSpec {
    @PropDefault
    static final int height = 400;

//    @OnCreateInitialState
//    static void createInitialState(
//            ComponentContext c,
//            StateValue<Boolean> isExpanded) {
//        isExpanded.set(false);
//    }

    @OnCreateLayout
    static ComponentLayout onCreateLayout(
            ComponentContext c,
            @Prop(optional = true) int height) {
//            @State boolean isExpanded

        return Column.create(c)
                .heightPx(height)
                .paddingDip(VERTICAL, 8)
                .paddingDip(HORIZONTAL, 40)
                .justifyContent(SPACE_BETWEEN)
                .child(
                        SpaceBetweenText.create(c)
                                .marginTop(20)
                                .textLeft("04月27日 星期四")
                                .sizeLeft(10)
                                .textRight("G101")
                                .sizeRight(14)
                                .withLayout()
                                .flexGrow(1)
                )
                .child(
                        StationTime.create(c)
                                .time("06:22")
                                .station("北京南站")
                                .withLayout()
                                .flexGrow(1)
                )
                .child(
                        StationTime.create(c)
                                .time("16:22")
                                .station("北京北站")
                                .withLayout()
                                .flexGrow(1)
                )
                .child(
                        SpaceBetweenText.create(c)
                                .marginBottom(20)
                                .textLeft("约5小时")
                                .sizeLeft(10)
                                .textRight("获取失败")
                                .sizeRight(14)
                                .withLayout()
                                .flexGrow(1)
                )
//                .clickHandler(TrainCard.onClick(c))
                .build();
    }
//
//    @OnUpdateState
//    static void updateExpanded(StateValue<Boolean> isExpanded) {
//        isExpanded.set(!isExpanded.get());
//    }
//
//    @OnEvent(ClickEvent.class)
//    static void onClick(
//            ComponentContext c) {
//        TrainCard.updateExpanded(c);
////        TrainCard.updateExpandedAsync(c);
//    }

}
