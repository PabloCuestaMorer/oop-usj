#include "AircraftCarrier.h"

AircraftCarrier::AircraftCarrier()
	: Ship("Aircraft Carrier", AIRCRAFT_CARRIER_SIZE)
{
}

AircraftCarrier::AircraftCarrier(const string& name, int size)
	: Ship(name, size)
{
}

