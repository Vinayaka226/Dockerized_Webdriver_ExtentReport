package pageObjects.automationExercise.records;

public record UserDetailsRecord(String name,
                                String email,
                                String password,
                                String day,
                                String month,
                                String year,
                                String address1,
                                String state,
                                String city,
                                String zip,
                                String mobile) {
}