package com.example.rent2gojavaproject.controllers;

import com.example.rent2gojavaproject.core.utilities.results.DataResult;
import com.example.rent2gojavaproject.core.utilities.results.Result;
import com.example.rent2gojavaproject.services.abstracts.BillService;
import com.example.rent2gojavaproject.services.dtos.requests.billRequest.AddBillRequest;
import com.example.rent2gojavaproject.services.dtos.requests.billRequest.UpdateBillRequest;
import com.example.rent2gojavaproject.services.dtos.responses.billResponse.GetBillListResponse;
import com.example.rent2gojavaproject.services.dtos.responses.billResponse.GetBillResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bills")
@AllArgsConstructor
@CrossOrigin
public class BillsController {
    private final BillService billService;

    @GetMapping()
    public DataResult<List<GetBillListResponse>> getAllCar() {

        return this.billService.getAllBills();
    }

    @GetMapping()
    public DataResult<GetBillResponse> getById(@PathVariable int id) {

        return this.billService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public Result createCar(@RequestBody @Valid AddBillRequest addBillRequest) {

        return this.billService.addBill(addBillRequest);
    }

    @PutMapping()
    @ResponseStatus(code = HttpStatus.OK)
    public Result updateCar(@RequestBody @Valid UpdateBillRequest updateBillRequest) {

        return this.billService.updateBill(updateBillRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Result deleteCar(@PathVariable int id) {

        return this.billService.deleteBill(id);
    }

    @GetMapping("/getallsoftdelete")
    public DataResult<Iterable<GetBillListResponse>> findAll(@RequestParam boolean isActive) {

        return this.billService.findAll(isActive);
    }
}
