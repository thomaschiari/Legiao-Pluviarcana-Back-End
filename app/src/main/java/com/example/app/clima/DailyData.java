package com.example.app.clima;

import lombok.*;
import java.util.*;

@Getter
@Setter
public class DailyData {
    private List<String> time;
    private List<Double> precipitation_sum;
    private List<Double> precipitation_probability_mean;
}
