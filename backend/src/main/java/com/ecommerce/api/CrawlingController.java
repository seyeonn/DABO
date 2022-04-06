package com.ecommerce.api;

import com.ecommerce.api.wallet.WalletController;
import com.ecommerce.application.IWalletService;
import com.ecommerce.domain.exception.NotFoundException;
import com.ecommerce.domain.repository.entity.BloodStatus;
import com.ecommerce.domain.repository.entity.Wallet;
import io.swagger.annotations.ApiOperation;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CrawlingController {

    public static final Logger logger = LoggerFactory.getLogger(WalletController.class);

    @ApiOperation(value = "Get Blood Status")
    @RequestMapping(value = "/blood", method = RequestMethod.GET)
    public BloodStatus getBlood() {
        logger.debug("getBlood start");

        final String url = "https://www.bloodinfo.net/bloodstats_stocks.do";
        Connection conn = Jsoup.connect(url);

//        Document document = conn.get();
//        Elements imageUrlElements = document.select()



        BloodStatus newBloodStatus = new BloodStatus();

        return newBloodStatus;
    }

}
