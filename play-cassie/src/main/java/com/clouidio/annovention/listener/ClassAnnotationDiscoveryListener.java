/*
 * Copyright 2012 ClouidIO Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.clouidio.annovention.listener;

/**
 * The Interface ClassAnnotationDiscoveryListener.
 * 
 * @author animesh.kumar
 */
public interface ClassAnnotationDiscoveryListener extends AnnotationDiscoveryListener {

	/**
	 * Gets called by the Discoverer with class-name of the class where annotation is found.
	 * 
	 * @param clazz			
	 * @param annotation
	 */
	void discovered(String clazz, String annotation);
}
