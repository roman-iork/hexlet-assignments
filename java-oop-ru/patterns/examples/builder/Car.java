package exercise.builder;

import java.awt.Color;

@SuppressWarnings({"FinalClass", "HiddenField"})
public class Car {
    private String name;
    private int doorsAmount;
    private double enginePower;
    private Color color;

    public String getName() {
        return name;
    }

    public int getDoorsAmount() {
        return doorsAmount;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public Color getColor() {
        return color;
    }

    public Car() {

    }

    public static Builder newBuilder() {
        return new Car().new Builder();
    }

    public final class Builder {
        private String name;
        private int doorsAmount;
        private double enginePower;
        private Color color;

        private Builder() {

        }

        public Builder setName(String carName) {
            this.name = carName;
            return this;
        }

        public Builder setDoorsAmount(int doors) {
            this.doorsAmount = doors;
            return this;
        }

        public Builder setEnginePower(double power) {
            this.enginePower = power;
            return this;
        }

        public Builder setColor(Color carColor) {
            this.color = carColor;
            return this;
        }

        public Car build() {
            Car.this.color = this.color;
            Car.this.doorsAmount = this.doorsAmount;
            Car.this.enginePower = this.enginePower;
            Car.this.name = name;
            return Car.this;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("name='").append(name).append('\'');
        sb.append(", doorsAmount=").append(doorsAmount);
        sb.append(", enginePower=").append(enginePower);
        sb.append(", color=").append(color);
        sb.append('}');
        return sb.toString();
    }
}
