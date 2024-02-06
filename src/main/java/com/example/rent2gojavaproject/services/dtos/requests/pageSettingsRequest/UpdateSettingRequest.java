package com.example.rent2gojavaproject.services.dtos.requests.pageSettingsRequest;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSettingRequest {

    @NotNull(message = "The settings id cannot be null.")
    @Positive(message = "Id must be a positive number.")
    private int id;
}
