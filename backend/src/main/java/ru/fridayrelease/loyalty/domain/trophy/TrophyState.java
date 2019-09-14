package ru.fridayrelease.loyalty.domain.trophy;

/**
 * @author avbelyaev
 */
public enum TrophyState {

    AVAILABLE {
        @Override
        public boolean cantTransitTo(TrophyState state) {
            return state == COMPLETED;
        }
    },
    COMPLETED {
        @Override
        public boolean cantTransitTo(TrophyState state) {
            return state == AVAILABLE;
        }
    };

    public abstract boolean cantTransitTo(TrophyState state);
}
