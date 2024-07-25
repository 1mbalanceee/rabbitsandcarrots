package ru.headhunter;

import java.util.Arrays;
import java.util.Comparator;

public class CarrotTransport {
    public static void main(String[] args) {
        int[] carrotPatches = {1, 2, 3, 4, 5};


        final int MAX_CARRY = 5;
        final int MAX_TRIPS = 10;


        int totalCarrots = 0;
        int tripsMade = 0;


        Patch[] patches = new Patch[carrotPatches.length];
        for (int i = 0; i < carrotPatches.length; i++) {
            patches[i] = new Patch(i, carrotPatches[i]);
        }


        Arrays.sort(patches, Comparator.comparingInt(Patch::getCarrots).reversed());


        for (Patch patch : patches) {
            while (patch.carrots > 0 && tripsMade < MAX_TRIPS) {
                int toCarry = Math.min(patch.carrots, MAX_CARRY);
                totalCarrots += toCarry;
                patch.carrots -= toCarry;
                tripsMade++;
                if (tripsMade >= MAX_TRIPS) {
                    break;
                }
            }
            if (tripsMade >= MAX_TRIPS) {
                break;
            }
        }


        System.out.println("Количество морковок всего: " + totalCarrots);
    }
}

// ����� ��� ������������� �������
class Patch {
    int index;
    int carrots;

    public Patch(int index, int carrots) {
        this.index = index;
        this.carrots = carrots;
    }

    public int getCarrots() {
        return carrots;
    }
}
