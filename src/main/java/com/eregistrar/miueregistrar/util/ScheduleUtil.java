package com.eregistrar.miueregistrar.util;

import com.eregistrar.miueregistrar.exceptions.CourseRegisterException;
import com.eregistrar.miueregistrar.model.Block;
import com.eregistrar.miueregistrar.model.Course;
import com.eregistrar.miueregistrar.model.ERole;
import com.eregistrar.miueregistrar.model.User;

public class ScheduleUtil {
    public static boolean isStudent(User user) throws CourseRegisterException {
        boolean isStudent = user.getRoles().stream().anyMatch(role -> role.getName().equals(ERole.ROLE_STUDENT));
        if(!isStudent) {
            throw new CourseRegisterException("Given user id does not belongs to a student.");
        }
        return true;
    }

    public static boolean isFaculty(User user) throws CourseRegisterException {
        boolean isFaculty = user.getRoles().stream().anyMatch(role -> role.getName().equals(ERole.ROLE_FACULTY));
        if(!isFaculty) {
            throw new CourseRegisterException("Given user id does not belongs to a faculty.");
        }
        return true;
    }

    public static boolean isCourseExist(Course course) throws CourseRegisterException {
        if(course == null) {
            throw new CourseRegisterException("Given course id does not belongs to a course.");
        }
        return true;
    }

    public static boolean isBlockExist(Block block) throws CourseRegisterException {
        if(block == null) {
            throw new CourseRegisterException("Given block id does not belongs to a block.");
        }
        return true;
    }
}
