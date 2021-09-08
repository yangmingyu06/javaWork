/**
 * @(#)Student.java, 9月 08, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package mingyu.jdbc.data;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author yangmingyu
 */
@Data
@AllArgsConstructor
public class Student {

    public String name;

    public boolean gender;

    public int grade;

    public int score;
}