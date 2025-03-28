package kr.pet.mvc;

import java.util.ArrayList;
import java.util.List;

public class CustomerController {
    //고객 정보에 ArrayList가 필요하다 -> 왜? -> 여러명의 고객을 관리해야 하기 때문.
    private List<Customer> customers;

    //고객은 진료기록을 가지고 있어서
    private MedicalRecordController recordController; //진료기록을 관리하는 컨트롤러

    public CustomerController(MedicalRecordController recordController) {
        this.customers = new ArrayList<>();
        this.recordController = recordController;
    }

    //고객정보를 등록하는 메서드
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    //고객정보를 삭제하는 메서드(+반드시 해당 고객의 진료기록도 함께 삭제)
    public void removeCustomer(String phoneNumber) {
        for(int i = 0 ; i < customers.size(); i++){
            if(customers.get(i).getPhoneNumber().equals(phoneNumber)){
                customers.remove(i);
                recordController.removeMedicalRecord(phoneNumber); //해당 고객의 진료 기록 삭제
                break;
            }
        }
    }

    //고객등록 여부를 확인하는 메서드
    public Customer findCustomer(String phoneNumber) {
        for(Customer customer : customers){
            if(customer.getPhoneNumber().equals(phoneNumber)){
                return customer; // 전화번호와 일치하는 정보가 있으면 그 정보를 넘기고
            }
        }
        return null; // 전화번호와 일치하는 정보가 없으면 null을 넘긴다.
    }

    //기존의 전화번호로 이미 등록된 고객이 있는지를 확인하는 메서드(중복여부 확인)
    public boolean isPhoneNumberExist(String phoneNumber) {
        for(Customer customer : customers){
            if(customer.getPhoneNumber().equals(phoneNumber)){ //일치하는 전화번호가 있으면 true를 반환(즉, 중복된다면 true)
                return true;
            }
        }
        return false; //중복되지 않는다면 false를 반환한다
    }
}
