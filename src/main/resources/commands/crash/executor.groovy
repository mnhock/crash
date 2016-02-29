package commands

import org.crsh.text.ui.UIBuilder;
import com.github.example.crash.ThreadPoolExecutorMetrics;
import com.github.example.crash.RandomTaskService;

class executor {

    @Usage("Display metrics provided by the executor service")
    @Command
    public void main(InvocationContext context) {

        context.takeAlternateBuffer();
        try {
            while (!Thread.interrupted()) {
                out.cls()
                out.show(new UIBuilder().table(columns:[1]) {
                    header {
                        table(columns:[1], separator: dashed) {
                            header(bold: true, fg: black, bg: white) { label("metrics"); }
                        }
                    }
                    row {
                        table(columns:[1, 1]) {
                            header(bold: true, fg: black, bg: white) {
                            	label("NAME")
								label("VALUE")
                            }

                            ThreadPoolExecutorMetrics metrics = context.attributes['spring.beanfactory'].getBean(RandomTaskService.class).getThreadPoolExecutorMetrics();
                            
                            metrics.metaClass.methods.findAll {it.name.startsWith('get')}.sort().each { method ->
								row {
									label(method.name)
									label(method.invoke(metrics))
								}
							}
                        }
                    }
                });
                out.flush();
                Thread.sleep(1000);
            }
        } finally {
            context.releaseAlternateBuffer();
        }
    }
}