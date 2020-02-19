package de.interview.fizzbuzz.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

//@Data
@NoArgsConstructor
@RequiredArgsConstructor
//@Entity
//@Table(name = "fizzbuzz_table")
public class FizzBuzzOutput {
    //    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="PROJECT_SEQ_GEN")
//    @SequenceGenerator(name="PROJECT_SEQ_GEN", sequenceName="PROJECT_SEQ_GEN", allocationSize=1)
//    @Id
//    @NonNull
//    @GeneratedValue
//    @Column(name = "id", updatable = false, nullable = false)
//    private Long id;

//    @Id
//    @GeneratedValue(strategy=GenerationType.SEQUENCE)
//    private long id;

//    @Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    private Long id;

    @NonNull
    private int input;
    private String value;
    private String timestamp;

    public FizzBuzzOutput(@NonNull int input, String value, String timestamp) {
        this.input = input;
        this.value = value;
        this.timestamp = timestamp;
    }

//    public long getId() {
//        return id;
//    }

    public int getInput() {
        return input;
    }

    public void setInput(int input) {
        this.input = input;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
