package bai5.example.it210_ss02_btth.service;

import bai5.example.it210_ss02_btth.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public Student findByMsv(String msv) {

        switch (msv) {
            case "SV001":
                return new Student("SV001", "Nguyễn Văn An", "Công nghệ thông tin", 3, 8.5);

            case "SV002":
                return new Student("SV002", "Trần Thị Bình", "Kinh tế", 2, 7.2);

            case "SV003":
                return new Student("SV003", "Lê Minh Cường", "Công nghệ thông tin", 4, 3.8);

            default:
                return null;
        }
    }
}