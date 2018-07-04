package org.rapidpm.vaadin.nano;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.rapidpm.dependencies.core.logger.HasLogger;


@Route("")
public class VaadinApp extends Composite<Div> implements HasLogger {

  // read http://vaadin.com/testing for more infos
//  public static final String BTN_CLICK_ME   = buttonID().apply(VaadinApp.class, "btn-click-me");
//  public static final String LB_CLICK_COUNT = labelID().apply(VaadinApp.class, "lb-click-count");
  public static final String BTN_CLICK_ME   = "btn-click-me";
  public static final String LB_CLICK_COUNT = "lb-click-count";

  private final Button         btnClickMe   = new Button("click me");
  private       Label          lbClickCount = new Label("0");
  private final VerticalLayout layout       = new VerticalLayout(btnClickMe, lbClickCount);

  private int clickcount = 0;

  public VaadinApp() {
    btnClickMe.setId(BTN_CLICK_ME);
    btnClickMe.addClickListener(event -> {
      clickcount = clickcount + 1;
      lbClickCount.setText(String.valueOf(clickcount));
    });

    lbClickCount.setId(LB_CLICK_COUNT);

    //set the main Component
    getContent().add(layout);
  }
}
