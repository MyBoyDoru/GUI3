package com.denistechs.carrentalgui3.repository;

import com.denistechs.carrentalgui3.domain.CarRental;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarRentalRepository extends MemoryRepository<Integer, CarRental> {
    /***
     * Constructor for the Car Rental Repository
     */
    public CarRentalRepository() {
    }

    /***
     * Returns the size of the Car Rental Repository
     * @return int with the size
     */
    public int getSize() {
        return this.repo.size();
    }

    /***
     * String representation of the Car Rental Repository
     * @return String with the representation
     */
    @Override
    public String toString() {
        //Same concept as the CarRepository, StringBuilder is better in this case
        StringBuilder sb = new StringBuilder();
        Iterable<CarRental> i = this.repo.values();
        for(CarRental cr : i)
        {
            sb.append(cr.toString()).append("\n");
        }
        return sb.toString();
    }

    public double getMinPrice(){
        double min = Double.MAX_VALUE;
        for(CarRental cr : this.repo.values()){
            if(cr.getCost() <= min){
                min = cr.getCost();
            }
        }
        return min;
    }

    public double getMaxPrice(){
        double max = Double.MIN_VALUE;
        for(CarRental cr : this.repo.values()){
            if(cr.getCost() >= max){
                max = cr.getCost();
            }
        }
        return max;
    }
}