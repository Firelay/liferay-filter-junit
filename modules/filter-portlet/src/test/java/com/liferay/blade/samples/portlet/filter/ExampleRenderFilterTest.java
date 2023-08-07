package com.liferay.blade.samples.portlet.filter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.filter.FilterChain;
import java.io.IOException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ExampleRenderFilterTest {

  @Test
  void testDoFilter() throws PortletException, IOException {
    RenderRequest request = Mockito.mock(RenderRequest.class);
    RenderResponse response = Mockito.mock(RenderResponse.class);
    FilterChain chain = Mockito.mock(FilterChain.class);

    ExampleRenderFilter exampleRenderFilter = new ExampleRenderFilter();
    exampleRenderFilter.doFilter(request, response, chain);

    Mockito.verify(request).setAttribute("CUSTOM_ATTRIBUTE", "My Custom Attribute Value");
    Mockito.verify(chain).doFilter(request, response);
  }
}
