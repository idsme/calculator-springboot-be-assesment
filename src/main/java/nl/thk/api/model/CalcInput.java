package nl.thk.api.model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CalcInput {
    public int a;
    public int b;

    public CalcInput(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
