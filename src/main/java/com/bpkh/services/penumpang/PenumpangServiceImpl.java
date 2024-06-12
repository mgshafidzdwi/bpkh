package com.bpkh.services.penumpang;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bpkh.model.Penumpang;
import com.bpkh.model.dao.penumpang.PenumpangDao;
import com.bpkh.model.dto.request.penumpang.ListAddPenumpangRequestDto;
import com.bpkh.model.dto.request.penumpang.ListUpdatePenumpangRequestDto;
import com.bpkh.model.dto.response.penumpang.PenumpangResponseDto;

import lombok.experimental.var;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PenumpangServiceImpl implements PenumpangService {

    @Autowired
    private PenumpangDao penumpangDao;

    @Override
    public PenumpangResponseDto addPenumpang(ListAddPenumpangRequestDto request) {
        PenumpangResponseDto response = new PenumpangResponseDto();
        try {
            var listPenumpang = request.getDataPenumpang();
            for (var data : listPenumpang) {
                String noTelp = penumpangDao.findNoTelp(data.getNoTelp());
                if (noTelp.equalsIgnoreCase(data.getNoTelp())) {
                    response.setHttpCode(HttpStatus.BAD_REQUEST.value());
                    response.setResponseCode("02");
                    response.setResponseDesc("No Telp already exist");
                    response.setResponseData(null);
                    return response;
                }
                Penumpang penumpang = new Penumpang();
                penumpang.setNama(data.getNama());
                penumpang.setNoTelp(data.getNoTelp());
                penumpangDao.save(penumpang);
            }
            response.setHttpCode(HttpStatus.OK.value());
            response.setResponseCode("00");
            response.setResponseDesc("Success");
            response.setResponseData(listPenumpang);
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
    public PenumpangResponseDto getPenumpang(Long id) {
        PenumpangResponseDto response = new PenumpangResponseDto();
        if (id != 0) {
            var penumpang = penumpangDao.findById(id);
            List<Penumpang> listPenumpang = new ArrayList<>();
            if (penumpang == null) {
                response.setHttpCode(HttpStatus.NOT_FOUND.value());
                response.setResponseCode("01");
                response.setResponseDesc("Data not found");
                response.setResponseData(null);
            } else {
                listPenumpang.add(penumpang.get());
                response.setHttpCode(HttpStatus.OK.value());
                response.setResponseCode("00");
                response.setResponseDesc("Success");
                response.setResponseData(listPenumpang);
            }
        } else {
            var penumpang = penumpangDao.findAll();
            List<Penumpang> listPenumpang = new ArrayList<>();
            if (penumpang == null) {
                response.setHttpCode(HttpStatus.NOT_FOUND.value());
                response.setResponseCode("01");
                response.setResponseDesc("Data not found");
                response.setResponseData(null);
            } else {
                for (var data : penumpang) {
                    listPenumpang.add(data);
                }
                response.setHttpCode(HttpStatus.OK.value());
                response.setResponseCode("00");
                response.setResponseDesc("Success");
                response.setResponseData(listPenumpang);
            }
        }

        return response;
    }

    @Override
    public PenumpangResponseDto updatePenumpang(ListUpdatePenumpangRequestDto request) {
        PenumpangResponseDto response = new PenumpangResponseDto();
        try {
            var listPenumpang = request.getDataPenumpang();
            for (var data : listPenumpang) {
                var penumpang = penumpangDao.findById(data.getId()).orElse(null);
                if (penumpang == null) {
                    response.setHttpCode(HttpStatus.NOT_FOUND.value());
                    response.setResponseCode("01");
                    response.setResponseDesc("Data not found");
                    response.setResponseData(null);
                    return response;
                } else {
                    penumpang.setId(data.getId());
                    if (data.getNama() != null) {
                        penumpang.setNama(data.getNama());
                    }
                    if (data.getNoTelp() != null) {
                        String noTelp = penumpangDao.findNoTelp(data.getNoTelp());
                        if (noTelp.equalsIgnoreCase(data.getNoTelp())) {
                            response.setHttpCode(HttpStatus.BAD_REQUEST.value());
                            response.setResponseCode("02");
                            response.setResponseDesc("No Telp already exist");
                            response.setResponseData(null);
                            return response;
                        }
                        penumpang.setNoTelp(data.getNoTelp());
                    }
                    penumpangDao.save(penumpang);
                }
            }
            response.setHttpCode(HttpStatus.OK.value());
            response.setResponseCode("00");
            response.setResponseDesc("Success");
            response.setResponseData(listPenumpang);
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
    public PenumpangResponseDto deletePenumpang(Long id) {
        PenumpangResponseDto response = new PenumpangResponseDto();
        List<Penumpang> listPenumpang = new ArrayList<>();
        try {
            var penumpang = penumpangDao.findById(id).orElse(null);
            if (penumpang == null) {
                response.setHttpCode(HttpStatus.NOT_FOUND.value());
                response.setResponseCode("01");
                response.setResponseDesc("Data not found");
                response.setResponseData(null);
                return response;
            } else {
                listPenumpang.add(penumpang);
                penumpangDao.delete(penumpang);
            }
            response.setHttpCode(HttpStatus.OK.value());
            response.setResponseCode("00");
            response.setResponseDesc("Success Delete Data");
            response.setResponseData(listPenumpang);
        } catch (Exception e) {
            log.info("Error : {}", e.getMessage());
            response.setHttpCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setResponseCode("99");
            response.setResponseDesc("Failed");
            response.setResponseData(null);
        }

        return response;
    }
}