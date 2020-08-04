/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pago.chinchin.Crypto.controller;

import com.pago.chinchin.Crypto.entity.CryptoTableMaster;
import com.pago.chinchin.Crypto.models.BeanPTR_Primary;
import com.pago.chinchin.Crypto.models.BeanUnitModelBS;
import com.pago.chinchin.Crypto.models.CryptoEntryDataModel;
import com.pago.chinchin.Crypto.models.CryptoResponseDataModelBS;
import com.pago.chinchin.Crypto.models.CryptoResponseDataModelBTC;
import com.pago.chinchin.Crypto.models.CryptoResponseDataModelDASH;
import com.pago.chinchin.Crypto.models.CryptoResponseDataModelETH;
import com.pago.chinchin.Crypto.models.CryptoResponseDataModelEUR;
import com.pago.chinchin.Crypto.models.CryptoResponseDataModelPTR;
import com.pago.chinchin.Crypto.models.ModelBS;
import com.pago.chinchin.Crypto.models.ModelBTC;
import com.pago.chinchin.Crypto.models.ModelDASH;
import com.pago.chinchin.Crypto.models.ModelETH;
import com.pago.chinchin.Crypto.models.ModelEUR;
import com.pago.chinchin.Crypto.models.ModelPTR;
import com.pago.chinchin.Crypto.models.ModelPTR_Entry;
import com.pago.chinchin.Crypto.models.ModelPTR_Primary;
import com.pago.chinchin.Crypto.models.ModelPTR_Response;
import com.pago.chinchin.Crypto.models.ModelUpdate_BS;
import com.pago.chinchin.Crypto.models.ModelUpdate_PTR;
import com.pago.chinchin.Crypto.models.ResponseMDPGeneric;
import com.pago.chinchin.Crypto.models.UnitModelBS;
import com.pago.chinchin.Crypto.models.UnitModelBTC;
import com.pago.chinchin.Crypto.models.UnitModelDASH;
import com.pago.chinchin.Crypto.models.UnitModelETH;
import com.pago.chinchin.Crypto.models.UnitModelEUR;
import com.pago.chinchin.Crypto.service.ICryptoService;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author amarciales
 */
@RestController
@RequestMapping("/api.pagochinchin.com/1.0/crypto")
public class CryptoController {
    
    @Autowired
    RestTemplate restTemplate;
    
    @Autowired
    ICryptoService ICS;

    @PostMapping(path="/conversion")
    public Object PostCryptoEquivalence(@RequestBody CryptoEntryDataModel CEDM) {
        
        switch (CEDM.getCurrency()){
            
        case "BTC":
            
            UnitModelBTC BTC_UMBTC=PostUnitPriceBTC();
            UnitModelETH BTC_UMETH=PostUnitPriceETH();
            UnitModelDASH BTC_UMDASH=PostUnitPriceDASH();
            UnitModelEUR BTC_UMEUR=PostUnitPriceEUR();
            ModelPTR_Response BTC_MPTRR=PostUnitPricePTR();
            UnitModelBS BTC_UMBS=PostUnitPriceBS();
            double BTC_UnitBs_to_USD=BTC_UMBS.getUSD().getUSD()/BTC_UMBS.getUSD().getDolartoday_BS();
            
            CryptoResponseDataModelBTC CRDM_BTC=new CryptoResponseDataModelBTC();
            CRDM_BTC.setConversion_BS(new ModelBS());
            CRDM_BTC.setConversion_ETH(new ModelETH());
            CRDM_BTC.setConversion_DASH(new ModelDASH());
            CRDM_BTC.setConversion_EUR(new ModelEUR());
            CRDM_BTC.setConversion_PTR(new ModelPTR());
            
            CRDM_BTC.getConversion_BS().setBS((BTC_UMBTC.getUSD()/BTC_UnitBs_to_USD)*(CEDM.getMount().doubleValue()));
            CRDM_BTC.getConversion_BS().setUSD(Double.valueOf(CRDM_BTC.getConversion_BS().getBS())*BTC_UnitBs_to_USD);
            
            CRDM_BTC.getConversion_ETH().setETH((BTC_UMBTC.getUSD()/BTC_UMETH.getUSD()*(CEDM.getMount().doubleValue())));
            CRDM_BTC.getConversion_ETH().setUSD(Double.valueOf(CRDM_BTC.getConversion_ETH().getETH())*BTC_UMETH.getUSD());
            
            CRDM_BTC.getConversion_DASH().setDASH((BTC_UMBTC.getUSD()/BTC_UMDASH.getUSD()*(CEDM.getMount().doubleValue())));
            CRDM_BTC.getConversion_DASH().setUSD(Double.valueOf(CRDM_BTC.getConversion_DASH().getDASH())*BTC_UMDASH.getUSD());
            
            CRDM_BTC.getConversion_EUR().setEUR((BTC_UMBTC.getUSD()/BTC_UMEUR.getUSD()*(CEDM.getMount().doubleValue())));
            CRDM_BTC.getConversion_EUR().setUSD(Double.valueOf(CRDM_BTC.getConversion_EUR().getEUR())*BTC_UMEUR.getUSD());
            
            CRDM_BTC.getConversion_PTR().setPTR((BTC_UMBTC.getUSD()/BTC_MPTRR.getData().getPTR().getUSD()*(CEDM.getMount().doubleValue())));
            CRDM_BTC.getConversion_PTR().setUSD(Double.valueOf(CRDM_BTC.getConversion_PTR().getPTR())*BTC_MPTRR.getData().getPTR().getUSD());

            return CRDM_BTC;//ICS.GetDetails().get();

        case "ETH":  
            UnitModelBTC ETH_UMBTC=PostUnitPriceBTC();
            UnitModelETH ETH_UMETH=PostUnitPriceETH();
            UnitModelDASH ETH_UMDASH=PostUnitPriceDASH();
            UnitModelEUR ETH_UMEUR=PostUnitPriceEUR();
            ModelPTR_Response ETH_MPTRR=PostUnitPricePTR();
            UnitModelBS ETH_UMBS=PostUnitPriceBS();
            double ETH_UnitBs_to_USD=ETH_UMBS.getUSD().getUSD()/ETH_UMBS.getUSD().getDolartoday_BS();
            
            CryptoResponseDataModelETH CRDM_ETH=new CryptoResponseDataModelETH();
            CRDM_ETH.setConversion_BS(new ModelBS());
            CRDM_ETH.setConversion_BTC(new ModelBTC());
            CRDM_ETH.setConversion_DASH(new ModelDASH());
            CRDM_ETH.setConversion_EUR(new ModelEUR());
            CRDM_ETH.setConversion_PTR(new ModelPTR());

            CRDM_ETH.getConversion_BS().setBS((ETH_UMETH.getUSD()/ETH_UnitBs_to_USD*(CEDM.getMount().doubleValue())));
            CRDM_ETH.getConversion_BS().setUSD(Double.valueOf(CRDM_ETH.getConversion_BS().getBS())*ETH_UnitBs_to_USD);

            CRDM_ETH.getConversion_BTC().setBTC((ETH_UMETH.getUSD()/ETH_UMBTC.getUSD()*(CEDM.getMount().doubleValue())));
            CRDM_ETH.getConversion_BTC().setUSD(Double.valueOf(CRDM_ETH.getConversion_BTC().getBTC())*ETH_UMBTC.getUSD());

            CRDM_ETH.getConversion_DASH().setDASH((ETH_UMETH.getUSD()/ETH_UMDASH.getUSD()*(CEDM.getMount().doubleValue())));
            CRDM_ETH.getConversion_DASH().setUSD(Double.valueOf(CRDM_ETH.getConversion_DASH().getDASH())*ETH_UMDASH.getUSD());

            CRDM_ETH.getConversion_EUR().setEUR((ETH_UMETH.getUSD()/ETH_UMEUR.getUSD()*(CEDM.getMount().doubleValue())));
            CRDM_ETH.getConversion_EUR().setUSD(Double.valueOf(CRDM_ETH.getConversion_EUR().getEUR())*ETH_UMEUR.getUSD());

            CRDM_ETH.getConversion_PTR().setPTR((ETH_UMETH.getUSD()/ETH_MPTRR.getData().getPTR().getUSD()*(CEDM.getMount().doubleValue())));
            CRDM_ETH.getConversion_PTR().setUSD(Double.valueOf(CRDM_ETH.getConversion_PTR().getPTR())*ETH_MPTRR.getData().getPTR().getUSD());

            return CRDM_ETH;

        case "DASH":  
            UnitModelBTC DASH_UMBTC=PostUnitPriceBTC();
            UnitModelETH DASH_UMETH=PostUnitPriceETH();
            UnitModelDASH DASH_UMDASH=PostUnitPriceDASH();
            UnitModelEUR DASH_UMEUR=PostUnitPriceEUR();
            ModelPTR_Response DASH_MPTRR=PostUnitPricePTR();
            UnitModelBS DASH_UMBS=PostUnitPriceBS();
            double DASH_UnitBs_to_USD=DASH_UMBS.getUSD().getUSD()/DASH_UMBS.getUSD().getDolartoday_BS();
            
            CryptoResponseDataModelDASH CRDM_DASH=new CryptoResponseDataModelDASH();
            CRDM_DASH.setConversion_BS(new ModelBS());
            CRDM_DASH.setConversion_BTC(new ModelBTC());
            CRDM_DASH.setConversion_ETH(new ModelETH());
            CRDM_DASH.setConversion_EUR(new ModelEUR());
            CRDM_DASH.setConversion_PTR(new ModelPTR());

            CRDM_DASH.getConversion_BS().setBS(DASH_UMDASH.getUSD()/DASH_UnitBs_to_USD*(CEDM.getMount().doubleValue()));
            CRDM_DASH.getConversion_BS().setUSD(Double.valueOf(CRDM_DASH.getConversion_BS().getBS())*DASH_UnitBs_to_USD);

            CRDM_DASH.getConversion_BTC().setBTC((DASH_UMDASH.getUSD()/DASH_UMBTC.getUSD()*(CEDM.getMount().doubleValue())));
            CRDM_DASH.getConversion_BTC().setUSD(Double.valueOf(CRDM_DASH.getConversion_BTC().getBTC())*DASH_UMBTC.getUSD());

            CRDM_DASH.getConversion_ETH().setETH((DASH_UMDASH.getUSD()/DASH_UMETH.getUSD()*(CEDM.getMount().doubleValue())));
            CRDM_DASH.getConversion_ETH().setUSD(Double.valueOf(CRDM_DASH.getConversion_ETH().getETH())*DASH_UMETH.getUSD());

            CRDM_DASH.getConversion_EUR().setEUR((DASH_UMDASH.getUSD()/DASH_UMEUR.getUSD()*(CEDM.getMount().doubleValue())));
            CRDM_DASH.getConversion_EUR().setUSD(Double.valueOf(CRDM_DASH.getConversion_EUR().getEUR())*DASH_UMEUR.getUSD());

            CRDM_DASH.getConversion_PTR().setPTR((DASH_UMDASH.getUSD()/DASH_MPTRR.getData().getPTR().getUSD()*(CEDM.getMount().doubleValue())));
            CRDM_DASH.getConversion_PTR().setUSD(Double.valueOf(CRDM_DASH.getConversion_PTR().getPTR())*DASH_MPTRR.getData().getPTR().getUSD());

            return CRDM_DASH;

        case "PTR":  
            UnitModelBTC PTR_UMBTC=PostUnitPriceBTC();
            UnitModelETH PTR_UMETH=PostUnitPriceETH();
            UnitModelDASH PTR_UMDASH=PostUnitPriceDASH();
            ModelPTR_Response PTR_MPTRR=PostUnitPricePTR();
            UnitModelEUR PTR_UMEUR=PostUnitPriceEUR();
            UnitModelBS PTR_UMBS=PostUnitPriceBS();
            double PTR_UnitBs_to_USD=PTR_UMBS.getUSD().getUSD()/PTR_UMBS.getUSD().getDolartoday_BS();
            
            CryptoResponseDataModelPTR CRDM_PTR=new CryptoResponseDataModelPTR();
            CRDM_PTR.setConversion_BS(new ModelBS());
            CRDM_PTR.setConversion_BTC(new ModelBTC());
            CRDM_PTR.setConversion_ETH(new ModelETH());
            CRDM_PTR.setConversion_EUR(new ModelEUR());
            CRDM_PTR.setConversion_DASH(new ModelDASH());

            CRDM_PTR.getConversion_BS().setBS(PTR_MPTRR.getData().getPTR().getUSD()/PTR_UnitBs_to_USD*(CEDM.getMount().doubleValue()));
            CRDM_PTR.getConversion_BS().setUSD(Double.valueOf(CRDM_PTR.getConversion_BS().getBS())*PTR_UnitBs_to_USD);

            CRDM_PTR.getConversion_BTC().setBTC((PTR_MPTRR.getData().getPTR().getUSD()/PTR_UMBTC.getUSD()*(CEDM.getMount().doubleValue())));
            CRDM_PTR.getConversion_BTC().setUSD(Double.valueOf(CRDM_PTR.getConversion_BTC().getBTC())*PTR_UMBTC.getUSD());

            CRDM_PTR.getConversion_ETH().setETH((PTR_MPTRR.getData().getPTR().getUSD()/PTR_UMETH.getUSD()*(CEDM.getMount().doubleValue())));
            CRDM_PTR.getConversion_ETH().setUSD(Double.valueOf(CRDM_PTR.getConversion_ETH().getETH())*PTR_UMETH.getUSD());

            CRDM_PTR.getConversion_EUR().setEUR((PTR_MPTRR.getData().getPTR().getUSD()/PTR_UMEUR.getUSD()*(CEDM.getMount().doubleValue())));
            CRDM_PTR.getConversion_EUR().setUSD(Double.valueOf(CRDM_PTR.getConversion_EUR().getEUR())*PTR_UMEUR.getUSD());

            CRDM_PTR.getConversion_DASH().setDASH((PTR_MPTRR.getData().getPTR().getUSD()/PTR_UMDASH.getUSD()*(CEDM.getMount().doubleValue())));
            CRDM_PTR.getConversion_DASH().setUSD(Double.valueOf(CRDM_PTR.getConversion_DASH().getDASH())*PTR_UMDASH.getUSD());

            return CRDM_PTR;

        case "BS":  
            UnitModelBTC BS_UMBTC=PostUnitPriceBTC();
            UnitModelETH BS_UMETH=PostUnitPriceETH();
            UnitModelDASH BS_UMDASH=PostUnitPriceDASH();
            UnitModelEUR BS_UMEUR=PostUnitPriceEUR();
            ModelPTR_Response BS_MPTRR=PostUnitPricePTR();
            UnitModelBS BS_UMBS=PostUnitPriceBS();
            double BS_UnitBs_to_USD=BS_UMBS.getUSD().getUSD()/BS_UMBS.getUSD().getDolartoday_BS();
            
            CryptoResponseDataModelBS CRDM_BS=new CryptoResponseDataModelBS();
            CRDM_BS.setConversion_EUR(new ModelEUR());
            CRDM_BS.setConversion_BTC(new ModelBTC());
            CRDM_BS.setConversion_ETH(new ModelETH());
            CRDM_BS.setConversion_PTR(new ModelPTR());
            CRDM_BS.setConversion_DASH(new ModelDASH());

            CRDM_BS.getConversion_EUR().setEUR(BS_UnitBs_to_USD/BS_UMEUR.getUSD()*(CEDM.getMount().doubleValue()));
            CRDM_BS.getConversion_EUR().setUSD(Double.valueOf(CRDM_BS.getConversion_EUR().getEUR())*BS_UMEUR.getUSD());

            CRDM_BS.getConversion_BTC().setBTC((BS_UnitBs_to_USD/BS_UMBTC.getUSD()*(CEDM.getMount().doubleValue())));
            CRDM_BS.getConversion_BTC().setUSD(Double.valueOf(CRDM_BS.getConversion_BTC().getBTC())*BS_UMBTC.getUSD());

            CRDM_BS.getConversion_ETH().setETH((BS_UnitBs_to_USD/BS_UMETH.getUSD()*(CEDM.getMount().doubleValue())));
            CRDM_BS.getConversion_ETH().setUSD(Double.valueOf(CRDM_BS.getConversion_ETH().getETH())*BS_UMETH.getUSD());

            CRDM_BS.getConversion_PTR().setPTR((BS_UnitBs_to_USD/BS_MPTRR.getData().getPTR().getUSD()*(CEDM.getMount().doubleValue())));
            CRDM_BS.getConversion_PTR().setUSD(Double.valueOf(CRDM_BS.getConversion_PTR().getPTR())*BS_MPTRR.getData().getPTR().getUSD());

            CRDM_BS.getConversion_DASH().setDASH((BS_UnitBs_to_USD/BS_UMDASH.getUSD()*(CEDM.getMount().doubleValue())));
            CRDM_BS.getConversion_DASH().setUSD(Double.valueOf(CRDM_BS.getConversion_DASH().getDASH())*BS_UMDASH.getUSD());

            return CRDM_BS;

        case "EUR":  
            UnitModelBTC EUR_UMBTC=PostUnitPriceBTC();
            UnitModelETH EUR_UMETH=PostUnitPriceETH();
            UnitModelDASH EUR_UMDASH=PostUnitPriceDASH();
            UnitModelBS EUR_UMBS=PostUnitPriceBS();
            ModelPTR_Response EUR_MPTRR=PostUnitPricePTR();
            UnitModelEUR EUR_UMEUR=PostUnitPriceEUR();
            double EUR_UnitBs_to_USD=EUR_UMBS.getUSD().getUSD()/EUR_UMBS.getUSD().getDolartoday_BS();
            
            CryptoResponseDataModelEUR CRDM_EUR=new CryptoResponseDataModelEUR();
            CRDM_EUR.setConversion_BS(new ModelBS());
            CRDM_EUR.setConversion_BTC(new ModelBTC());
            CRDM_EUR.setConversion_ETH(new ModelETH());
            CRDM_EUR.setConversion_PTR(new ModelPTR());
            CRDM_EUR.setConversion_DASH(new ModelDASH());

            CRDM_EUR.getConversion_BS().setBS(EUR_UMEUR.getUSD()/EUR_UnitBs_to_USD*(CEDM.getMount().doubleValue()));
            CRDM_EUR.getConversion_BS().setUSD(Double.valueOf(CRDM_EUR.getConversion_BS().getBS())*EUR_UnitBs_to_USD);

            CRDM_EUR.getConversion_BTC().setBTC((EUR_UMEUR.getUSD()/EUR_UMBTC.getUSD()*(CEDM.getMount().doubleValue())));
            CRDM_EUR.getConversion_BTC().setUSD(Double.valueOf(CRDM_EUR.getConversion_BTC().getBTC())*EUR_UMBTC.getUSD());

            CRDM_EUR.getConversion_ETH().setETH((EUR_UMEUR.getUSD()/EUR_UMETH.getUSD()*(CEDM.getMount().doubleValue())));
            CRDM_EUR.getConversion_ETH().setUSD(Double.valueOf(CRDM_EUR.getConversion_ETH().getETH())*EUR_UMETH.getUSD());

            CRDM_EUR.getConversion_PTR().setPTR((EUR_UMEUR.getUSD()/EUR_MPTRR.getData().getPTR().getUSD()*(CEDM.getMount().doubleValue())));
            CRDM_EUR.getConversion_PTR().setUSD(Double.valueOf(CRDM_EUR.getConversion_PTR().getPTR())*EUR_MPTRR.getData().getPTR().getUSD());

            CRDM_EUR.getConversion_DASH().setDASH((EUR_UMEUR.getUSD()/EUR_UMDASH.getUSD()*(CEDM.getMount().doubleValue())));
            CRDM_EUR.getConversion_DASH().setUSD(Double.valueOf(CRDM_EUR.getConversion_DASH().getDASH())*EUR_UMDASH.getUSD());

            return CRDM_EUR;

        default: 
            ResponseMDPGeneric RMDPG = new ResponseMDPGeneric();
            RMDPG.setStatusCode(500);
            RMDPG.setStatusCodeDescription("Los tipos de criptomeda permitidos para conversión en el servicio son: BTC,ETH,DASH,PTR,BS y EUR");
            return RMDPG;
        }

    }
    
    @PostMapping(path="/UpdatePTR")
    public ResponseMDPGeneric PostUpdatePTR(@RequestBody ModelUpdate_PTR MUPTR) {
        ICS.UpdatePTR(MUPTR.getMount_PTR());
        ResponseMDPGeneric RMDPG = new ResponseMDPGeneric();
        RMDPG.setStatusCode(200);
        RMDPG.setStatusCodeDescription("Actualización Monto Petro Satisfactorio.");
        return RMDPG;
    }

    @PostMapping(path="/UpdateBS")
    public ResponseMDPGeneric PostUpdateBS(@RequestBody ModelUpdate_BS MUBS) {
        ICS.UpdateBS(MUBS.getCount_unit());
        ResponseMDPGeneric RMDPG = new ResponseMDPGeneric();
        RMDPG.setStatusCode(200);
        RMDPG.setStatusCodeDescription("Actualización Cantidad de Unidades Bolívares Satisfactorio.");
        return RMDPG;
    }
    
    @PostMapping(path="/UnitPriceBTC")
    public UnitModelBTC PostUnitPriceBTC() {
        ResponseEntity<UnitModelBTC> responseBTC =
        restTemplate.getForEntity("https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=USD", UnitModelBTC.class);

        return responseBTC.getBody();
    }
        
    @PostMapping(path="/UnitPriceETH")
	public UnitModelETH PostUnitPriceETH() {
            ResponseEntity<UnitModelETH> responseETH =
            restTemplate.getForEntity("https://min-api.cryptocompare.com/data/price?fsym=ETH&tsyms=USD", UnitModelETH.class);
            return responseETH.getBody(); 
	}
        
    @PostMapping(path="/UnitPriceDASH")
	public UnitModelDASH PostUnitPriceDASH() {
            ResponseEntity<UnitModelDASH> responseDASH =
            restTemplate.getForEntity("https://min-api.cryptocompare.com/data/price?fsym=DASH&tsyms=USD", UnitModelDASH.class);
            return responseDASH.getBody();
	}
        
    @PostMapping(path="/UnitPriceEUR")
	public UnitModelEUR PostUnitPriceEUR() {
            ResponseEntity<UnitModelEUR> responseEUR =
            restTemplate.getForEntity("https://min-api.cryptocompare.com/data/price?fsym=EUR&tsyms=USD", UnitModelEUR.class);
            return responseEUR.getBody();
            
	}
        
    @PostMapping(path="/UnitPricePTR")
    public ModelPTR_Response PostUnitPricePTR() {
        try{
        RestTemplate restTemplate = new RestTemplate();
        ModelPTR_Entry MPTRE = new ModelPTR_Entry();
        ResponseEntity<ModelPTR_Response> responsePTR =
            restTemplate.postForEntity("https://petroapp-price.petro.gob.ve/price/", MPTRE, ModelPTR_Response.class);
        return responsePTR.getBody();
        }catch(org.springframework.web.client.ResourceAccessException e){
            System.out.println("HTTP Status Code Exception: "+e.getMessage());
        }finally{
            Optional<CryptoTableMaster> CTM = ICS.GetDetails("PTR");
            ModelPTR_Response MPTRR = new ModelPTR_Response();
            MPTRR.setData(new ModelPTR_Primary());
            MPTRR.getData().setPTR(new BeanPTR_Primary());
            if(CTM.isPresent()){
                MPTRR.getData().getPTR().setUSD(CTM.get().getUsd());
            }
            return MPTRR;
        }

    }

    @PostMapping(path="/UnitPriceBS")
    public UnitModelBS PostUnitPriceBS() {
        try{
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setAcceptCharset(Arrays.asList(Charset.forName("UTF-8")));
        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity<UnitModelBS> responseBS =
        restTemplate.exchange("https://s3.amazonaws.com/dolartoday/data.json", HttpMethod.GET, entity, UnitModelBS.class);
        return responseBS.getBody();
        }catch(org.springframework.web.client.ResourceAccessException e){
            System.out.println("HTTP Status Code Exception: "+e.getMessage());
        }finally{
            Optional<CryptoTableMaster> CTM = ICS.GetDetails("BS");
            UnitModelBS UMBS = new UnitModelBS();
            UMBS.setUSD(new BeanUnitModelBS());
            if(CTM.isPresent()){
                UMBS.getUSD().setDolartoday_BS(CTM.get().getCountUnit().doubleValue());
            }
            return UMBS;
        }
    }
}
