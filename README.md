
<center>
<a href="https://vaadin.com">
 <img src="https://vaadin.com/images/hero-reindeer.svg" width="200" height="200" /></a>
</center>


# Nano Vaadin - Ramp up in a second.
A nano project to start a Vaadin project. Perfect for Micro-UIs packed as fat jar in a docker image.

## Supported JDK
This example is running from JDK8 up to JDK13

## Support for Heroku
To support the Heroku pipeline we need a few preparations.
1) the app must be able to get a configured port for the http port during the start up
1) add the shade plugin to create a fat jar
1) create the file **Procfile** and add the line 
    ``web: java -jar target/vaadin-app.jar -port $PORT```
    * **web** - to activate the web profile
    * **-jar** - define what fat jar must be started
    * **-port** make the dynamic associated port available for the app
1) add a file **settings.xml** to configure the maven build process

## target of this project
The target of this project is a minimal rampup time for a first hello world.
Why we need one more HelloWorld? Well, the answer is quite easy. 
If you have to try something out, or you want to make a small POC to present something,
there is no time and budget to create a demo project.
You don´t want to copy paste all small things together.
Here you will get a Nano-Project that will give you all in a second.

Clone the repo and start editing the class ```HelloWorld``` and ```VaadinApp```.
Nothing more. 

## How does it work?
Internally it will ramp up an Undertow. If you want to see how this is done, have a look inside
the class ```CoreUIService```.

## How a developer can use this
You as a developer can use it like it is shown in the demo folder inside the test src path.

```java
public class HelloWorld {
  public static void main(String[] args) {
    new CoreUIService() {
      @Override
      public Set<Class<?>> setOfRouteAnnotatedClasses() {
        return Collections.singleton(VaadinApp.class);
      }
    }.startup();
  }
}
```


```java
@Route("")
public class VaadinApp extends Composite<Div> implements HasLogger {

  public static final String BTN_CLICK_ME   = "btn-click-me";
  public static final String LB_CLICK_COUNT = "lb-click-count";

  private final Button         btnClickMe   = new Button("click me");
  private final Span           lbClickCount = new Span("0");
  private final VerticalLayout layout       = new VerticalLayout(btnClickMe, lbClickCount);

  private int clickcount = 0;

  public VaadinApp() {
    btnClickMe.setId(BTN_CLICK_ME);
    btnClickMe.addClickListener(event -> lbClickCount.setText(String.valueOf(++clickcount)));

    lbClickCount.setId(LB_CLICK_COUNT);

    logger().info("and now..  setting the main content.. ");
    getContent().add(layout);
  }
}
```

Happy Coding.

if you have any questions: ping me on Twitter [https://twitter.com/SvenRuppert](https://twitter.com/SvenRuppert)
or via mail.



## Info

WebJarServer : Zeile 102