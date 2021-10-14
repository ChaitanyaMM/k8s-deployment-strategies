package com.deployment.strategies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AcutatorController {

	@Autowired

	private ApplicationEventPublisher eventPublisher;

	public AcutatorController(ApplicationEventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}

	@GetMapping("/complete-normally")
	public String completeNormally() throws Exception {
		return "Hello from Controller";
	}

	@GetMapping("/i-will-sleep-for-30sec")
	public String destroy() throws Exception {
		System.out.println("------------------ Sleeping for 30 sec");
		Thread.sleep(30000);
		return "sleep complete";
	}

	@GetMapping("/readiness/accepting")
	public String markReadinesAcceptingTraffic() {
		AvailabilityChangeEvent.publish(eventPublisher, this, ReadinessState.ACCEPTING_TRAFFIC);
		return "Readiness marked as ACCEPTING_TRAFFIC";
	}

	@GetMapping("/readiness/refuse")
	public String markReadinesRefusingTraffic() {
		AvailabilityChangeEvent.publish(eventPublisher, this, ReadinessState.REFUSING_TRAFFIC);
		return "Readiness marked as REFUSING_TRAFFIC";
	}

	@GetMapping("/liveness/correct")
	public String markLivenessCorrect() {
		AvailabilityChangeEvent.publish(eventPublisher, this, LivenessState.CORRECT);
		return "Liveness marked as CORRECT";
	}

	@GetMapping("/liveness/broken")
	public String markLivenessBroken() {
		AvailabilityChangeEvent.publish(eventPublisher, this, LivenessState.BROKEN);
		return "Liveness marked as BROKEN";
	}

}
