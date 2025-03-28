package kr.pet.mvc;

import java.util.ArrayList;
import java.util.List;

public class MedicalRecordController {
    private List<MedicalRecord> records = new ArrayList<>();//여러개의 진료기록을 저장해야 함 -> 이 리스트에는 여러 동물들의 진료기록이 담겨있다.


    //잔료기록을 등록하는 메서드
    public void addMedicalRecord(MedicalRecord medicalRecord) {
        records.add(medicalRecord);
    }

    //진료기록을 삭제하는 메서드
    public void removeMedicalRecord(String phoneNumber){
        for(int i = 0; i < records.size(); i++){
            if(records.get(i).getPhoneNumber().equals(phoneNumber)){
                records.remove(i);
                break;
            }
        }
    }

    //위 records 리스트에서 전화번호와 일치하는 것만 가져와 한 동물이 가지고 있는 여러개의 진료기록을 저장하는 리스트를 만들어준다
    public List<MedicalRecord> findMedicalRecords(String phoneNumber){
        List<MedicalRecord> result = new ArrayList<>();

        for(MedicalRecord record : records){
            if(record.getPhoneNumber().equals(phoneNumber)){
                result.add(record);
            }
        }
        return result;
    }
}
