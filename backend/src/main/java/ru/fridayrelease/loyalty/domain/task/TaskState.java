package ru.fridayrelease.loyalty.domain.task;

/**
 * @author avbelyaev
 */
public enum TaskState {

    TODO {
        @Override
        public boolean cantTransitTo(TaskState state) {
            return state == IN_PROGRESS;
        }
    },
    IN_PROGRESS {
        @Override
        public boolean cantTransitTo(TaskState state) {
            return state == COMPLETED;
        }
    },
    // terminal state
    COMPLETED {
        @Override
        public boolean cantTransitTo(TaskState state) {
            return false;
        }
    };

    public abstract boolean cantTransitTo(TaskState state);
}
