package org.sid.billing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
//@RefreshScope /*mise a jour la configuration lorsqu'il change*/
public class ConsulConfigRestController {
@Autowired
    private MyConsulConfig myConsulConfig;


   // private MyConsulConfig myConsulConfig;
   // @Value("${token.accessTokenTimeout}")
 //  private long accessTokenTimeout;
  ///  @Value("${token.refreshTokenTimeout}")
   // private long refreshTokenTimeout;

    @GetMapping("/myConfig")
    public MyConsulConfig myConsulConfig() {
return myConsulConfig;
    }


}
