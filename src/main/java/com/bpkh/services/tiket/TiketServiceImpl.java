package com.bpkh.services.tiket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bpkh.model.Tiket;
import com.bpkh.model.dao.tiket.TiketDao;
import com.bpkh.model.dao.tiket.TiketJoinDao;
import com.bpkh.model.dto.request.tiket.GetTiketRequestDto;
import com.bpkh.model.dto.request.tiket.ListAddTiketRequestDto;
import com.bpkh.model.dto.request.tiket.ListUpdateTiketRequestDto;
import com.bpkh.model.dto.response.tiket.ListTiketResponseDto;
import com.bpkh.model.dto.response.tiket.TiketResponseDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TiketServiceImpl implements TiketService {

    @Autowired
    private TiketDao tiketDao;

    @Autowired
    private TiketJoinDao tiketJoinDao;

    @Override
    public TiketResponseDto addTiket(ListAddTiketRequestDto request) {
        TiketResponseDto response = new TiketResponseDto();
        try {
            var listTravel = request.getDataTiket();
            for (var data : listTravel) {
                Tiket tiket = new Tiket();
                tiket.setIdPenumpang(data.getIdPenumpang());
                tiket.setIdTravel(data.getIdTravel());
                tiket.setJadwal(data.getJadwal());
                tiketDao.save(tiket);
            }
            response.setHttpCode(HttpStatus.OK.value());
            response.setResponseCode("00");
            response.setResponseDesc("Success");
            response.setResponseData(request.getDataTiket());
        } catch (Exception e) {
            log.info("Error : {}", e.getMessage());
            response.setHttpCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setResponseCode("99");
            response.setResponseDesc("Failed");
            response.setResponseData(null);
        }
        return response;
    }

    @Override
    public ListTiketResponseDto getTiket(Long id) {
        ListTiketResponseDto response = new ListTiketResponseDto();
        List<Tiket> listTiket = new ArrayList<>();
        try {
            if (id != 0) {
                Tiket tiket = tiketDao.findById(id).orElse(null);
                listTiket = tiket != null ? Arrays.asList(tiket) : new ArrayList<>();

                response.setHttpCode(HttpStatus.OK.value());
                response.setResponseCode("00");
                response.setResponseDesc("Success");
                response.setResponseData(listTiket);
            } else {
                var tiket = tiketDao.findAll();
                for (var data : tiket) {
                    listTiket.add(data);
                }
                response.setHttpCode(HttpStatus.OK.value());
                response.setResponseCode("00");
                response.setResponseDesc("Success");
                response.setResponseData(listTiket);
            }
        } catch (Exception e) {
            log.info("Error : {}", e.getMessage());
            response.setHttpCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setResponseCode("99");
            response.setResponseDesc("Failed");
            response.setResponseData(null);
        }
        return response;
    }

    @Override
    public TiketResponseDto updateTiket(ListUpdateTiketRequestDto request) {
        TiketResponseDto response = new TiketResponseDto();
        try {
            var listTiket = request.getDataTiket();
            for (var data : listTiket) {
                var tiket = tiketDao.findById(data.getId()).orElse(null);
                if (tiket == null) {
                    response.setHttpCode(HttpStatus.NOT_FOUND.value());
                    response.setResponseCode("01");
                    response.setResponseDesc("Data not found");
                    response.setResponseData(null);
                    return response;
                } else {
                    // listTiket.add(data);
                    if (data.getIdPenumpang() != null) {
                        tiket.setIdPenumpang(data.getIdPenumpang());
                    }
                    if (data.getIdTravel() != null) {
                        tiket.setIdTravel(data.getIdTravel());
                    }
                    if (data.getJadwal() != null) {
                        tiket.setJadwal(data.getJadwal());
                    }
                    tiketDao.save(tiket);
                }
            }
            response.setHttpCode(HttpStatus.OK.value());
            response.setResponseCode("00");
            response.setResponseDesc("Success");
            response.setResponseData(listTiket);
        } catch (Exception e) {
            log.info("Error : {}", e);
            response.setHttpCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setResponseCode("99");
            response.setResponseDesc("Failed");
            response.setResponseData(null);
        }

        return response;
    }

    @Override
    public TiketResponseDto deleteTiket(Long id) {
        TiketResponseDto response = new TiketResponseDto();
        List<Tiket> listTiket = new ArrayList<>();
        try {
            var tiket = tiketDao.findById(id).orElse(null);
            if (tiket == null) {
                response.setHttpCode(HttpStatus.NOT_FOUND.value());
                response.setResponseCode("01");
                response.setResponseDesc("Data not found");
                response.setResponseData(null);
                return response;
            } else {
                listTiket.add(tiket);
                tiketDao.delete(tiket);
            }
            response.setHttpCode(HttpStatus.OK.value());
            response.setResponseCode("00");
            response.setResponseDesc("Success Delete Data");
            response.setResponseData(listTiket);
        } catch (Exception e) {
            log.info("Error : {}", e.getMessage());
            response.setHttpCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setResponseCode("99");
            response.setResponseDesc("Failed");
            response.setResponseData(null);
        }

        return response;
    }

    @Override
    public TiketResponseDto searchTiket(GetTiketRequestDto request) {
        TiketResponseDto response = new TiketResponseDto();
        if (request != null) {
            try {
                var tiket = tiketJoinDao.findByKeywordTiket(request.getKeyword());
                if (tiket == null) {
                    response.setHttpCode(HttpStatus.NOT_FOUND.value());
                    response.setResponseCode("01");
                    response.setResponseDesc("Data not found");
                    response.setResponseData(null);
                } else {
                    response.setHttpCode(HttpStatus.OK.value());
                    response.setResponseCode("00");
                    response.setResponseDesc("Success");
                    response.setResponseData(tiket);
                }
            } catch (Exception e) {
                log.info("Error : {}", e);
                response.setHttpCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
                response.setResponseCode("99");
                response.setResponseDesc("Failed");
                response.setResponseData(null);
            }
        } else {
            response.setHttpCode(HttpStatus.BAD_REQUEST.value());
            response.setResponseCode("02");
            response.setResponseDesc("Request is null");
            response.setResponseData(null);
        }
        return response;
    }
}