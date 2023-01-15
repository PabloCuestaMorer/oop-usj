#pragma once

#include "Ship.h"
const int AIRCRAFT_CARRIER_SIZE = 5;

class AircraftCarrier :
    public Ship
{
public:
	AircraftCarrier();
	AircraftCarrier(const string& name, int size = AIRCRAFT_CARRIER_SIZE);
};

