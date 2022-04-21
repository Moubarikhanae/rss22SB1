package fr.univrouen.rss22.controllers;

import fr.univrouen.rss22.model.Item;
import fr.univrouen.rss22.model.TestRSS;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
public class GetController {
    @GetMapping("/resume")
    public String getListRSSinXML(){
        return "Envoi de la liste des flux RSS";
    }

    @GetMapping ("/guid")
    public String getRSSinXML(@RequestParam(value="guid") String texte){
        return "Détail du contenu RSS demandé"+ texte;
    }

    @GetMapping("/test")
    public String testingRequestParam(@RequestParam("nb") Integer nombre, @RequestParam("search") String search){
        String newLine = System.getProperty("line.separator");
        return "Test:" +newLine+"guid="+ nombre+newLine+"titre="+search;
    }

    @RequestMapping(value="/testPOST",method = RequestMethod.POST,
    consumes = "aplication/xml")
    public String postTest(@RequestBody String flux){
        return ("<result><response>Message reçu : </response>"+flux+"</result>");
    }

    @RequestMapping(value="/testrss",produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public String postRSS(){
        TestRSS rss=new TestRSS();
        return rss.loadFileXML();
    }

    @RequestMapping(value="/xml", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public Item getXML(){
        Item it=new Item("12345678","Test item","2022-05-01T11:22:33");
        return it;
    }
}

