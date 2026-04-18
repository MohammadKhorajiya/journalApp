package journalApplication.Service;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import journalApplication.Entity.User;

import java.util.stream.Stream;

public class UserArgumentsProvider implements ArgumentsProvider
{
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
                Arguments.of(User.builder().username("Afrin_2026").password("Afrin@1998").build()));
    }
}
