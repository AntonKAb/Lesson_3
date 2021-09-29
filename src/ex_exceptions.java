package com.company;
import java.util.ArrayList;
import java.util.List;
import com.company.PhoneNumberAlreadyExists;
import com.company.RecordNotFound;
import com.company.RecordNotValid;
import com.company.Record;


public class PhoneBook {
    private ArrayList<Record> allRecords = new ArrayList<>();

    public List<Record> getAllRecords(){
        return allRecords;
    }

    //  Создаем новый контакт. Если в справочнике уже есть запись c таким номером телефона, принтуем
    //  проверяемое исключение PhoneNumberAlreadyExists.
    public void createRecord(Record record) {

        try{
            for (Record record1 : allRecords){
                if (record1.getPhoneNumber() == record1.getPhoneNumber()) throw new PhoneNumberAlreadyExists();
            }
            allRecords.add(record);
            System.out.println("Контакт добавлен.");
        }
        catch(PhoneNumberAlreadyExists exception) {
            System.out.println("Exception name: " + exception.toString());
            return;
        }
    }

    // Удаляем контакт из справочника по id, если подходящая запись в
    //  справочнике не найдена, то выбрасывается непроверяемое исключение RecordNotFound.
    public void deleteRecord(long idContact) {
        try{
            for(Record record: allRecords){

                if(record.getId() == idContact){
                    allRecords.remove(record);
                    System.out.println("Коетакт удален.");
                }
            }
            throw new RecordNotFound();
        }
        catch(RecordNotFound exception){
            System.out.println("Exception exception: " + exception.toString());
            return;
        }
    }

    public void updateRecord(Record record) {
        try{
            if(record.getId() == 0 | record.getPhoneNumber() == 0) {
                throw new RecordNotValid();
            }
            for(Record record1 : allRecords){
                if(record1.getId() == record.getId()) {
                    allRecords.remove(record1);
                    allRecords.add(record);
                    System.out.println("Обновлено");
                    return;
                }
            }
            throw new RecordNotFound();
        }
        catch(RecordNotFound exception){
            System.out.println("Exception name: " + exception.toString());
            return;
        }
        catch(RecordNotValid exception){
            System.out.println("Exception name: " + e.toString());
            return;
        }
//    метод обновляет запись в справочнике. Если запись с таким идентификатором
//    не существует, выбросить непроверяемое исключение RecordNotFound. Если в новой записи не заполнено поле name и/или
//    поле phoneNumber, выбросить проверяемое исключение RecordNotValid.
    }

}