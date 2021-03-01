package at.rtr.rmbt.controller;

import at.rtr.rmbt.request.TestServerRequest;
import at.rtr.rmbt.response.TestServerResponse;
import at.rtr.rmbt.service.TestServerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static at.rtr.rmbt.constant.URIConstants.BY_ID;
import static at.rtr.rmbt.constant.URIConstants.TEST_SERVER;

@RestController
@RequestMapping(TEST_SERVER)
@RequiredArgsConstructor
public class TestServerController {

    private final TestServerService testServerService;

    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Create new measurement server.")
    @PostMapping
    public void createTestServer(@Validated @RequestBody TestServerRequest testServerRequest) {
        testServerService.createTestServer(testServerRequest);
    }

    @ApiOperation("Get all measurement server.")
    @GetMapping
    public List<TestServerResponse> getAllTestServers(
            @ApiParam(value = "providerId") Long providerId
    ) {
        return testServerService.getAllTestServer();
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Update existing measurement server")
    @PutMapping(BY_ID)
    public void updateTestServer(@PathVariable Long id, @Validated @RequestBody TestServerRequest testServerRequest) {
        testServerService.updateTestServer(id, testServerRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = BY_ID)
    @ApiOperation("Delete existing measurement server by id")
    public void deleteTestServerById(@PathVariable Long id) {
        testServerService.deleteTestServer(id);
    }
}
