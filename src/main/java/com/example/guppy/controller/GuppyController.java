package com.example.guppy.controller;

import com.example.guppy.entity.Guppy;
import com.example.guppy.entity.GuppyAddDetail;
import com.example.guppy.entity.GuppyDetail;
import com.example.guppy.helper.Helper;
import com.example.guppy.service.GuppyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class GuppyController {
    @Autowired
    GuppyService guppyService;

    @RequestMapping("/hello")
    public String welcome() {
        System.out.println("welcome");
        return "welcome guppy store";
    }

    @PostMapping(path = "/admin/guppy")
    public int insertGuppy(@RequestBody List<Guppy> listGuppy) {
        System.out.println("enter insert : " + listGuppy);
        if(listGuppy.size() == 0) return 0;
        List<String> listNames = new ArrayList<>();
        List<String> listImages = new ArrayList<>();
        List<Float> listPrices = new ArrayList<>();;
        List<String> listDescribes = new ArrayList<>();

        listGuppy.forEach(g -> {
            if(g.getName().equals("")) return;
            listNames.add(g.getName());
            listImages.add(g.getImage());
            listPrices.add(g.getPrice());
            listDescribes.add(g.get_describe());
        });
        if(listNames.size() == 0) return 0;
        int vMax = listNames.size();
        String names = Helper.StrToString(listNames);
        String images = Helper.StrToString(listImages);
        String prices = Helper.FloToString(listPrices);
        String _describes = Helper.StrToString(listDescribes);

        return guppyService.insertGuppy(vMax, names, images, prices, _describes);
    }

//    @GetMapping("/guppy/{id}")
//    public Guppy selectGuppyById(@PathVariable("id") int id) {
//        System.out.println("select a guppy by id = " + id);
//        return guppyService.selectGuppyById(id);
//    }

    @GetMapping("/guppy")
    public List<Guppy> selectAllGuppy() {
        System.out.println("select all guppy");
        return guppyService.selectAllGuppy();
    }

    @DeleteMapping("/admin/guppy/{id}")
    public int deleteGuppyById(@PathVariable("id") int id) {
        System.out.println("delete a guppy by id");
        return guppyService.deleteGuppyById(id);
    }

    @PutMapping("/admin/guppy")
    public int updateGuppy(@RequestBody Guppy guppyUpdate) {
        System.out.println("update a guppy id " + guppyUpdate.getName());

        return guppyService.updateGuppy(guppyUpdate);
    }

    @PostMapping("/admin/guppy-detail")
    public int insertGuppyDetails(@RequestBody GuppyAddDetail detail) {
        System.out.println("insert guppy detail");
        String listOfGuppy = Helper.IntToString(detail.listGuppy);
        String listOfImages = Helper.IntToString(detail.listImages);
        String listOfVideos = Helper.IntToString(detail.listVideos);
        return guppyService.insertGuppyDetail(detail.vMax, listOfGuppy, listOfImages, listOfVideos);
    }
    @PostMapping(path = "/admin/guppy-info")
    public List<Guppy> adminGetListGuppy(@RequestBody String name) {
        System.out.println(name);
        if(name.equals("...")) return guppyService.selectAllGuppy();
        return guppyService.adminGetAllGuppy(name);
    }

    @GetMapping(path = "/guppy/{id}")
    public GuppyDetail getGuppyDetail(@PathVariable("id") int id) {
        System.out.println(("get detail guppy id= " + id));
        return guppyService.getGuppyDetail(id);
    }

    @PostMapping(path = "admin/guppy/{id}/quantity")
    public int updateQuantity(@PathVariable("id") int id, @RequestBody int quantity) {
        System.out.println("update quantity: " + id + quantity);
        return guppyService.updateQuantity(quantity, id);
    }

}
