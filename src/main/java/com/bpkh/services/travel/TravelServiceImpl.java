package com.bpkh.services.travel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bpkh.model.Travel;
import com.bpkh.model.dao.travel.TravelDao;
import com.bpkh.model.dto.request.travel.GetTravelRequestDto;
import com.bpkh.model.dto.request.travel.ListAddTravelRequestDto;
import com.bpkh.model.dto.request.travel.ListUpdateTravelRequestDto;
import com.bpkh.model.dto.response.travel.TravelResponseDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TravelServiceImpl implements TravelService {

    @Autowired
    private TravelDao travelDao;

    @Override
    public TravelResponseDto addTravel(ListAddTravelRequestDto request) {
        TravelResponseDto response = new TravelResponseDto();
        try {
            var listTravel = request.getDataTravel();
            for (var data : listTravel) {
                Travel travel = new Travel();
                String noTelp = travelDao.findNoTelp(data.getNoTelp());
                if (noTelp.equalsIgnoreCase(data.getNoTelp())) {
                    response.setHttpCode(HttpStatus.BAD_REQUEST.value());
                    response.setResponseCode("02");
                    response.setResponseDesc("No Telp already exist");
                    response.setResponseData(null);
                    return response;
                }
                if (data.getNamaTravel() != null) {
                    travel.setNamaTravel(data.getNamaTravel());
                }
                if (data.getNoTelp() != null) {
                    travel.setNoTelp(data.getNoTelp());
                }
                if (data.getAlamat() != null) {
                    travel.setAlamat(data.getAlamat());
                }
                if (data.getNoPolisi() != null) {
                    travel.setNoPolisi(data.getNoPolisi());
                }
                if (data.getJenisBus() != null) {
                    travel.setJenisBus(data.getJenisBus());
                }
                travelDao.save(travel);
            }
            response.setHttpCode(HttpStatus.OK.value());
            response.setResponseCode("00");
            response.setResponseDesc("Success");
            response.setResponseData(request.getDataTravel());
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
    public TravelResponseDto getTravel(Long id) {
        TravelResponseDto response = new TravelResponseDto();
        List<Travel> listTravel = new ArrayList<>();
        if (id != 0) {
            var travel = travelDao.findById(id);
            if (travel == null) {
                response.setHttpCode(HttpStatus.NOT_FOUND.value());
                response.setResponseCode("01");
                response.setResponseDesc("Data not found");
                response.setResponseData(null);
            } else {
                listTravel.add(travel.get());
                response.setHttpCode(HttpStatus.OK.value());
                response.setResponseCode("00");
                response.setResponseDesc("Success");
                response.setResponseData(listTravel);
            }
        } else {
            var travel = travelDao.findAll();
            if (travel == null) {
                response.setHttpCode(HttpStatus.NOT_FOUND.value());
                response.setResponseCode("01");
                response.setResponseDesc("Data not found");
                response.setResponseData(null);
            } else {
                for (var data : travel) {
                    listTravel.add(data);
                }
                response.setHttpCode(HttpStatus.OK.value());
                response.setResponseCode("00");
                response.setResponseDesc("Success");
                response.setResponseData(listTravel);
            }
        }
        return response;
    }

    @Override
    public TravelResponseDto updateTravel(ListUpdateTravelRequestDto request) {
        TravelResponseDto response = new TravelResponseDto();
        try {
            var listTravel = request.getDataTravel();
            for (var data : listTravel) {
                var travel = travelDao.findById(data.getId()).orElse(null);
                if (travel == null) {
                    response.setHttpCode(HttpStatus.NOT_FOUND.value());
                    response.setResponseCode("01");
                    response.setResponseDesc("Data not found");
                    response.setResponseData(null);
                    return response;
                } else {
                    if (data.getNamaTravel() != null) {
                        travel.setNamaTravel(data.getNamaTravel());
                    }
                    if (data.getNoTelp() != null) {
                        String noTelp = travelDao.findNoTelp(data.getNoTelp());
                        if (noTelp.equalsIgnoreCase(data.getNoTelp())) {
                            response.setHttpCode(HttpStatus.BAD_REQUEST.value());
                            response.setResponseCode("02");
                            response.setResponseDesc("No Telp already exist");
                            response.setResponseData(null);
                            return response;
                        }
                        travel.setNoTelp(data.getNoTelp());
                    }
                    if (data.getAlamat() != null) {
                        travel.setAlamat(data.getAlamat());
                    }
                    if (data.getNoPolisi() != null) {
                        travel.setNoPolisi(data.getNoPolisi());
                    }
                    if (data.getJenisBus() != null) {
                        travel.setJenisBus(data.getJenisBus());
                    }
                    travelDao.save(travel);
                }
            }
            response.setHttpCode(HttpStatus.OK.value());
            response.setResponseCode("00");
            response.setResponseDesc("Success");
            response.setResponseData(listTravel);
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
    public TravelResponseDto deleteTravel(Long id) {
        TravelResponseDto response = new TravelResponseDto();
        List<Travel> listTravel = new ArrayList<>();
        try {
            var travel = travelDao.findById(id).orElse(null);
            if (travel == null) {
                response.setHttpCode(HttpStatus.NOT_FOUND.value());
                response.setResponseCode("01");
                response.setResponseDesc("Data not found");
                response.setResponseData(null);
                return response;
            } else {
                listTravel.add(travel);
                travelDao.delete(travel);
            }
            response.setHttpCode(HttpStatus.OK.value());
            response.setResponseCode("00");
            response.setResponseDesc("Success Delete Data");
            response.setResponseData(listTravel);
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
    public TravelResponseDto searchTravel(GetTravelRequestDto request) {
        TravelResponseDto response = new TravelResponseDto();
        if (request != null) {
            var travel = travelDao.findTravelByKeyword(request.getKeyword());
            if (travel == null) {
                response.setHttpCode(HttpStatus.NOT_FOUND.value());
                response.setResponseCode("01");
                response.setResponseDesc("Data not found");
                response.setResponseData(null);
            } else {
                response.setHttpCode(HttpStatus.OK.value());
                response.setResponseCode("00");
                response.setResponseDesc("Success");
                response.setResponseData(travel);
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