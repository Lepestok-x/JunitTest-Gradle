package com.example.links.factory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Expected {
    private final List<String> expected = new ArrayList<>();
    public Expected() {
        expected.add("Link has responded with staus 201 and status text Created");
        expected.add("Link has responded with staus 204 and status text No Content");
        expected.add("Link has responded with staus 301 and status text Moved Permanently");
        expected.add("Link has responded with staus 400 and status text Bad Request");
        expected.add("Link has responded with staus 401 and status text Unauthorized");
        expected.add("Link has responded with staus 403 and status text Forbidden");
        expected.add("Link has responded with staus 404 and status text Not Found");
    }
    public List<String> getExpected() {
        return Collections.unmodifiableList(expected);
    }
}
