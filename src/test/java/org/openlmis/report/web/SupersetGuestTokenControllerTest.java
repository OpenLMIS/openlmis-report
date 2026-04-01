/*
 * This program is part of the OpenLMIS logistics management information system platform software.
 * Copyright © 2017 VillageReach
 *
 * This program is free software: you can redistribute it and/or modify it under the terms
 * of the GNU Affero General Public License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Affero General Public License for more details. You should have received a copy of
 * the GNU Affero General Public License along with this program. If not, see
 * http://www.gnu.org/licenses.  For additional information contact info@OpenLMIS.org.
 */

package org.openlmis.report.web;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openlmis.report.service.SupersetService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

public class SupersetGuestTokenControllerTest {

  private static final String EMBEDDED_UUID = "test-dashboard-uuid";
  private static final String USERNAME = "testuser";
  private static final String GUEST_TOKEN = "mock-guest-token";

  @Mock
  private SupersetService supersetService;

  @InjectMocks
  private SupersetGuestTokenController controller;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @After
  public void tearDown() {
    SecurityContextHolder.clearContext();
  }

  @Test
  public void shouldReturnGuestToken() {
    // given
    SecurityContextHolder.getContext().setAuthentication(
        new UsernamePasswordAuthenticationToken(USERNAME, "password")
    );

    when(supersetService.getGuestToken(EMBEDDED_UUID, USERNAME, USERNAME, USERNAME))
        .thenReturn(GUEST_TOKEN);

    // when
    Map<String, String> result = controller.getGuestToken(EMBEDDED_UUID);

    // then
    assertEquals(GUEST_TOKEN, result.get("token"));
    assertEquals(1, result.size());
  }

  @Test(expected = NullPointerException.class)
  public void shouldThrowWhenNotAuthenticated() {
    // given - no security context / authentication set
    SecurityContextHolder.clearContext();

    // when
    controller.getGuestToken(EMBEDDED_UUID);
  }
}
