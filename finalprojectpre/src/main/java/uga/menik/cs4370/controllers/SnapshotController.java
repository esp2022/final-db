package uga.menik.cs4370.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import uga.menik.cs4370.models.Snapshot;
import uga.menik.cs4370.services.SnapshotService;

@Controller
@RequestMapping("/snapshot")
public class SnapshotController {
    private final SnapshotService snapshotService;

    @Autowired
    public SnapshotController(SnapshotService snapshotService) {
        this.snapshotService = snapshotService;
    }

    @GetMapping
    @ResponseBody
    public Snapshot getSnapshotValues() throws SQLException {
        return this.snapshotService.getSnapshot();
    }

}
