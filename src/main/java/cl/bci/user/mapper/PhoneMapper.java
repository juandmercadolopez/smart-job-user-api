package cl.bci.user.mapper;

import cl.bci.user.entity.Phone;
import cl.bci.user.model.request.PhoneModel;

import java.util.ArrayList;
import java.util.List;

public class PhoneMapper {

    public static List<Phone> mapPhoneRequestToPhoneEntity(List<PhoneModel> phoneRequestList, String uuid) {

        List<Phone> phoneEntityList = new ArrayList<>();

        phoneRequestList.forEach(phone -> {
            phoneEntityList.add(Phone.builder()
                    .number(phone.getNumber())
                    .cityCode(phone.getCityCode())
                    .countryCode(phone.getCountryCode())
                    .build());
        });

        return phoneEntityList;
    }

    public static List<PhoneModel> mapPhoneEntityToPhoneModel(List<Phone> phoneEntityList) {
        List<PhoneModel> phoneModelList = new ArrayList<>();
        phoneEntityList.forEach(phone -> {
            phoneModelList.add(PhoneModel.builder()
                    .number(phone.getNumber())
                    .cityCode(phone.getCityCode())
                    .countryCode(phone.getCountryCode())
                    .build());
        });
        return phoneModelList;
    }


}
