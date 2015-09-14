package info.bliki.extensions.scribunto.engine.lua.interfaces;

import info.bliki.extensions.scribunto.engine.lua.LuaTestBase;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MwUstringTest extends LuaTestBase {
    @Override
    public String getLuaTest() {
        return "UstringLibraryTests.lua";
    }

    public Set<String> ignoredTests() {
        return new HashSet<>(Arrays.asList(
            "char: invalid codepoint",
            "char: invalid value",
            "find: (%f 5)",
            "find: (%f 6)",
            "find: (%f 7)",
            "find: (%f 8)",
            "find: (%f 9)",
            "find: empty character set",
            "gsub: invalid replacement string",
            "string length limit",
            "pattern length limit"
        ));
    }
}
