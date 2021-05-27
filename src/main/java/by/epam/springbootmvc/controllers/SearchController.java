package by.epam.springbootmvc.controllers;

import by.epam.springbootmvc.beans.Product;
import by.epam.springbootmvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@Controller
public class SearchController {

    @Autowired
    private ProductRepository productRepository;

    @Qualifier("applicationTaskExecutor")
    @Autowired
    private AsyncTaskExecutor executor;

    //callable implementation
/*    @GetMapping("/search")
    public Callable<String> search(@RequestParam("search") String search, Model model) {
        System.out.println("inside search controller");
        System.out.println("search criteria: " + search);
        return () -> {
            Thread.sleep(3000);
            System.out.println("thread name: "+Thread.currentThread().getName());
            List<Product> products = new ArrayList<>();
            products = productRepository.searchByName(search);
            model.addAttribute("products", products);
            return "search";
        };
    }*/
//deferred result implementation
    @GetMapping("/search")
    public DeferredResult<String> search(@RequestParam("search") String search, Model model) {
        DeferredResult<String> deferredResult = new DeferredResult<>();
        System.out.println("inside search controller");
        System.out.println("search criteria: " + search);

        executor.execute(()->{
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread name: "+Thread.currentThread().getName());
            List<Product> products = new ArrayList<>();
            products = productRepository.searchByName(search);
            model.addAttribute("products", products);
            deferredResult.setResult("search");
        });
       return deferredResult;
    }
}
