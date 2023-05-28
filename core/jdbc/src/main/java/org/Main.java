package org;

import org.entities.BonusEntity;
import org.entities.TitleEntity;
import org.entities.WorkerEntity;

import java.sql.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        Date date = new java.sql.Date(new java.util.Date().getTime());
        // insert into worker
        WorkerEntity workerEntity = new WorkerEntity();
        workerEntity.setWORKER_ID(16);
        workerEntity.setFIRST_NAME("arezoo");
        workerEntity.setLAST_NAME("alipanah");
        workerEntity.setSALARY(500000);
        workerEntity.setJOINING_DATE(date);
        workerEntity.setDEPARTMENT("HR");
//        ORG.addWorker(workerEntity);

        // insert into bonus
        BonusEntity bonusEntity = new BonusEntity();
        bonusEntity.setWORKER_REF_ID(16);
        bonusEntity.setBONUS_AMOUNT(500000);
        bonusEntity.setBONUS_DATE(date);
//        ORG.addBonus(bonusEntity);

        // insert into title
        TitleEntity titleEntity = new TitleEntity();
        titleEntity.setWORKER_REF_ID(16);
        titleEntity.setWORKER_TITLE("Executive");
        titleEntity.setAFFECTED_FROM(date);
//        ORG.addTitle(titleEntity);

        System.out.println("-----question one");
        ORG.questionOne().stream().forEach(System.out::println);

        System.out.println("-----question two");
        ORG.questionTwo().stream().forEach(System.out::println);

        System.out.println("-----question four");
        ORG.questionFour().stream().forEach(System.out::println);

        System.out.println("-----question five");
        ORG.questionFive().stream().forEach(System.out::println);

        System.out.println("-----question six");
        ORG.questionSix().stream().forEach(System.out::println);

        System.out.println("-----question seven");
        ORG.questionSeven().stream().forEach(System.out::println);

        System.out.println("-----question eight");
        ORG.questionٔEight().stream().forEach(System.out::println);

        System.out.println("-----question nine");
        ORG.questionٔNine().stream().forEach(System.out::println);
    }
}
